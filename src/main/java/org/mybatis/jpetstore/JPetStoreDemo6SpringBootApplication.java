package org.mybatis.jpetstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class JPetStoreDemo6SpringBootApplication extends SpringBootServletInitializer {

  @Autowired
  private Environment env;

  public static void main(String[] args) {
    SpringApplication.run(new Class[] {JPetStoreDemo6SpringBootApplication.class}, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(JPetStoreDemo6SpringBootApplication.class);
  }

  @PostConstruct
  public void initApplication() throws Exception {

    if (env.getActiveProfiles().length == 0) {
      log.warn("No Spring profile configured, running with default configuration");
    } else {
      log.info("Running with Spring profile(s) : {}", env.getActiveProfiles());
    }
  }

}