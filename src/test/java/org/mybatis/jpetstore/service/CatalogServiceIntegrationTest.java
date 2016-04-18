package org.mybatis.jpetstore.service;

import com.google.common.collect.Lists;

import org.junit.Test;
import org.mybatis.jpetstore.AbstractIntegrationTest;
import org.mybatis.jpetstore.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Igor Baiborodine
 */
public class CatalogServiceIntegrationTest extends AbstractIntegrationTest {

  @Autowired private CatalogService catalogService;

  @Test
  public void searchProductList_databasePopulated_fetchedProductsWithNameEqualsToSpecifiedKeyword() throws Exception {
    // given
    //   product repository was populated during the app init
    // when
    String[] keywords = {"Angelfish", "Goldfish"};
    List<Product> products = catalogService.searchProductList(keywords);
    // then
    assertThat(products.size(), is(2));
    products.forEach(product ->
        assertThat(newArrayList(keywords).contains(product.getName()), is(true)));
  }

  @Test
  public void searchProductsByNameWithRegex_databasePopulated_fetchedProductsWithNameContainingSpecifiedKeyword() throws Exception {
    // given
    //   product repository was populated during the app init
    // when
    String keyword = "fish";
    List<Product> products = catalogService.searchProductsByNameWithRegex(keyword);
    // then
    assertThat(products.size(), is(2));
    products.forEach(product -> assertThat(product.getName().contains(keyword), is(true)));
  }

}
