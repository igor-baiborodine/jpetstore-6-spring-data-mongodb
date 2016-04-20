package org.mybatis.jpetstore.config;

import net.sourceforge.stripes.controller.StripesFilter;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.Servlet;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author Igor Baiborodine
 */
@Configuration
public class StripesConfig {

  @Bean()
  public Servlet dispatcherServlet() {
    return new net.sourceforge.stripes.controller.DispatcherServlet();
  }

  @Bean
  public ServletRegistrationBean stripesDispatcherServletRegistration() {

    ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet());
    registration.setName("stripesDispatcher");
    registration.addInitParameter("javax.servlet.jsp.jstl.fmt.localizationContext", "StripesResources");
    registration.addUrlMappings("*.action");
    registration.setLoadOnStartup(1);
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

}
