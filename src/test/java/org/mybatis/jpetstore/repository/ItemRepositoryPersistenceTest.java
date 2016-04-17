package org.mybatis.jpetstore.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.jpetstore.AbstractIntegrationTest;
import org.mybatis.jpetstore.JPetStoreDemo6SpringBootApplication;
import org.mybatis.jpetstore.domain.Item;
import org.mybatis.jpetstore.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Igor Baiborodine
 */
public class ItemRepositoryPersistenceTest extends AbstractIntegrationTest {

  @Autowired
  private ItemRepository itemRepository;
  @Autowired
  private ProductRepository productRepository;

  @Test
  public void count_repositoryPopulator_counted16Products() {
    // given
    //   repository was populated during the app init
    // when
    long count = itemRepository.count();
    // then
    assertThat(count, is(28L));
  }

  @Test
  public void findOne_repositoryPopulator_fetchedItemWithSpecifiedItemId() {
    // given
    //   repository was populated during the app init
    // when
    String itemId = "EST-2";
    Item item = itemRepository.findOne(itemId);
    // then
    assertThat(item, notNullValue());
    assertThat(item.getItemId(), is(itemId));
    assertThat(item.getListPrice(), is(new BigDecimal("16.50")));
    assertThat(item.getUnitCost(), is(new BigDecimal("10.00")));
    assertThat(item.getStatus(), is("P"));
    assertThat(item.getQuantity().intValue(), is(1000));
    assertThat(item.getAttribute1(), is("Small"));

    assertThat(item.getProduct(), notNullValue());
    Product product = productRepository.findOne(item.getProductId());
    assertThat(product, notNullValue());
    assertThat(EqualsBuilder.reflectionEquals(item.getProduct(), product), is(true));
  }

  @Test
  public void findByProduct_repositoryPopulator_fetchedItemsWithSpecifiedProduct() {
    // given
    //   repository was populated during the app init
    // when
    String productId = "FI-SW-01";
    Product product = productRepository.findOne(productId);
    List<Item> items = itemRepository.findByProduct(product);
    // then
    assertThat(items.size(), is(2));
    items.forEach(item -> assertThat(item.getProductId(), is(productId)));
  }

  @Test
  public void save_existingItem_itemQuantityUpdated() {
    // given
    //   repository was populated during the app init
    // when
    String itemId = "EST-2";
    Item item = itemRepository.findOne(itemId);
    item.setQuantity(item.getQuantity() - 1);
    itemRepository.save(item);
    Item updatedItem = itemRepository.findOne(itemId);
    // then
    assertThat(updatedItem.getQuantity(), is(item.getQuantity()));
  }

}
