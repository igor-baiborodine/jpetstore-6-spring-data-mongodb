package org.mybatis.jpetstore.config;

import static com.google.common.collect.Lists.newArrayList;

import org.mybatis.jpetstore.domain.Account;
import org.mybatis.jpetstore.domain.Category;
import org.mybatis.jpetstore.domain.Item;
import org.mybatis.jpetstore.domain.Order;
import org.mybatis.jpetstore.domain.Product;
import org.mybatis.jpetstore.domain.Sequence;
import org.mybatis.jpetstore.domain.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

import javax.annotation.PreDestroy;

/**
 * @author Igor Baiborodine
 */
@Configuration
@EnableAutoConfiguration
@EnableMongoRepositories(basePackages = "org.mybatis.jpetstore.repository")
public class MongoConfig {

  @Autowired
  private MongoOperations operations;

  @Bean
  public Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() {

    Jackson2RepositoryPopulatorFactoryBean factoryBean = new Jackson2RepositoryPopulatorFactoryBean();
    factoryBean.setResources(new Resource[]{
        new ClassPathResource("dataload/categories.json"),
        new ClassPathResource("dataload/products.json"),
        new ClassPathResource("dataload/suppliers.json"),
        new ClassPathResource("dataload/items.json"),
        new ClassPathResource("dataload/accounts.json"),
        new ClassPathResource("dataload/sequences.json")
    });
    return factoryBean;
  }

  /**
   * Clean up after execution by dropping used test db instance.
   */
  @PreDestroy
  void dropTestDB() throws Exception {
    //noinspection unchecked
    newArrayList(Account.class, Category.class, Item.class, Order.class, Product.class, Sequence.class, Supplier.class)
        .forEach(operations::dropCollection);
  }

}
