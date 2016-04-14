package org.mybatis.jpetstore.config;

import org.mybatis.jpetstore.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

import javax.annotation.PreDestroy;

/**
 * @author Igor Baiborodine
 */
@Configuration
@EnableAutoConfiguration
public class RepositoryConfig {

  @Autowired
  private MongoOperations operations;

  @Bean
  public Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() {

    Jackson2RepositoryPopulatorFactoryBean factoryBean = new Jackson2RepositoryPopulatorFactoryBean();
    factoryBean.setResources(new Resource[]{
        new ClassPathResource("dataload/categories.json"),
        new ClassPathResource("dataload/products.json"),
        new ClassPathResource("dataload/suppliers.json")
    });
    return factoryBean;
  }

  /**
   * Clean up after execution by dropping used test db instance.
   */
  @PreDestroy
  void dropTestDB() throws Exception {
    operations.dropCollection(Category.class);
  }

}
