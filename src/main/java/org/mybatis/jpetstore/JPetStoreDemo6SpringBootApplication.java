package org.mybatis.jpetstore;

import lombok.extern.slf4j.Slf4j;

import static javax.servlet.DispatcherType.REQUEST;

import net.sourceforge.stripes.controller.StripesFilter;

import org.mybatis.jpetstore.config.MongoConfig;
import org.mybatis.jpetstore.config.ServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.core.env.Environment;

import java.util.EnumSet;

import javax.annotation.PostConstruct;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Slf4j
@SpringBootApplication
public class JPetStoreDemo6SpringBootApplication extends SpringBootServletInitializer {

  @Autowired
  private Environment env;

  public static void main(String[] args) {
    SpringApplication.run(new Class[] {JPetStoreDemo6SpringBootApplication.class}, args);
  }

  @PostConstruct
  public void initApplication() throws Exception {

    if (env.getActiveProfiles().length == 0) {
      log.warn("No Spring profile configured, running with default configuration");
    } else {
      log.info("Running with Spring profile(s) : {}", env.getActiveProfiles());
    }
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(ServiceConfig.class, MongoConfig.class);
  }

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {

    servletContext.setInitParameter(
        "javax.servlet.jsp.jstl.fmt.localizationContext", "StripesResources");

    FilterRegistration.Dynamic stripesFilter = servletContext.addFilter(
        "stripesFilter", StripesFilter.class);
    stripesFilter.setInitParameter("ActionResolver.Packages", "org.mybatis.jpetstore.web");
    stripesFilter.setInitParameter(
        "Interceptor.Classes", "net.sourceforge.stripes.integration.spring.SpringInterceptor");
    stripesFilter.addMappingForServletNames(EnumSet.of(REQUEST), false, "stripesDispatcher");

    ServletRegistration.Dynamic stripesDispatcher = servletContext.addServlet(
        "stripesDispatcher", new net.sourceforge.stripes.controller.DispatcherServlet());
    stripesDispatcher.setLoadOnStartup(1);
    stripesDispatcher.addMapping("*.action");
    super.onStartup(servletContext);
  }

}
