package org.mybatis.jpetstore.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.jpetstore.JPetStoreDemo6SpringBootApplication;
import org.mybatis.jpetstore.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Igor Baiborodine
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JPetStoreDemo6SpringBootApplication.class)
public class ProductRepositoryPersistenceTest {

  @Autowired
  private ProductRepository productRepository;

  @Test
  public void count_repositoryPopulator_counted16Products() {
    // given
    //   repository was populated during the app init
    // when
    long count = productRepository.count();
    // then
    assertThat(count, is(16L));
  }

  @Test
  public void findOne_repositoryPopulator_fetchedProductWithSpecifiedProductId() {
    // given
    //   repository was populated during the app init
    // when
    String productId = "FI-SW-01";
    Product product = productRepository.findOne(productId);
    // then
    assertThat(product, notNullValue());
    assertThat(product.getProductId(), is(productId));
    assertThat(product.getCategoryId(), is("FISH"));
    assertThat(product.getName(), is("Angelfish"));
    assertThat(product.getDescription(), is("<image src='../images/fish1.gif'>Salt Water fish from Australia"));
  }

  @Test
  public void findByCategoryId_repositoryPopulator_fetchedProductsWithSpecifiedCategoryId() {
    // given
    //   repository was populated during the app init
    // when
    String categoryId = "FISH";
    List<Product> products = productRepository.findByCategoryId(categoryId);
    // then
    assertThat(products.size(), is(4));
    products.forEach(product -> assertThat(product.getCategoryId(), is(categoryId)));
  }

}