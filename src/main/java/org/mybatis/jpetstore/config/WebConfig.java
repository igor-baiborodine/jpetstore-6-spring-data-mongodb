package org.mybatis.jpetstore.config;

import static com.google.common.collect.Lists.newArrayList;

import net.sourceforge.stripes.controller.StripesFilter;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.Servlet;

/**
 * @author Igor Baiborodine
 */
@Configuration
public class WebConfig {

  @Bean()
  public Servlet staticContentDispatcher() {
    return new DispatcherServlet();
  }

  @Bean
  public ServletRegistrationBean staticContentDispatcherServletRegistration() {

    ServletRegistrationBean registration = new ServletRegistrationBean(staticContentDispatcher());
    registration.setName("staticContentDispatcher");
    registration.addUrlMappings("*.html");
    registration.setLoadOnStartup(1);
    return registration;
  }

  @Bean()
  public Servlet stripesDispatcher() {
    return new net.sourceforge.stripes.controller.DispatcherServlet();
  }

  @Bean
  public ServletRegistrationBean stripesDispatcherServletRegistration() {

    ServletRegistrationBean registration = new ServletRegistrationBean(stripesDispatcher());
    registration.setName("stripesDispatcher");
    registration.addInitParameter("javax.servlet.jsp.jstl.fmt.localizationContext", "StripesResources");
    registration.addUrlMappings("*.action");
    registration.setLoadOnStartup(2);
    return registration;
  }

  @Bean()
  public Filter stripesFilter() {
    return new StripesFilter();
  }

  @Bean
  public FilterRegistrationBean stripesFilterRegistration() {

    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setName("stripesFilter");
    registration.setFilter(stripesFilter());
    registration.addInitParameter("ActionResolver.Packages", "org.mybatis.jpetstore.web");
    registration.addInitParameter("Interceptor.Classes", "net.sourceforge.stripes.integration.spring.SpringInterceptor");
    registration.setServletNames(newArrayList("stripesDispatcher"));
    registration.setDispatcherTypes(DispatcherType.REQUEST);
    registration.setMatchAfter(false);

    return registration;
  }

  @Bean
  public WebMvcConfigurerAdapter forwardToIndex() {
    return new WebMvcConfigurerAdapter() {
      @Override
      public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:index.html");
      }
    };
  }

}
