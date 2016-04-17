package org.mybatis.jpetstore.repository;

import org.junit.Test;
import org.mybatis.jpetstore.AbstractIntegrationTest;
import org.mybatis.jpetstore.domain.Account;
import org.mybatis.jpetstore.domain.Cart;
import org.mybatis.jpetstore.domain.Item;
import org.mybatis.jpetstore.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * @author Igor Baiborodine
 */
public class OrderRepositoryPersistenceTest extends AbstractIntegrationTest {

  private static final String USERNAME = "pfry";
  private static final String ITEM_ID = "EST-1";

  @Autowired
  private OrderRepository orderRepository;
  @Autowired
  private AccountRepository accountRepository;
  @Autowired
  private ItemRepository itemRepository;

  @Test
  public void save_newOrder_insertedNewOrder() {
    // given
    Order order = createOrder(1000);
    // when
    orderRepository.save(order);
    // then
    Order insertedOrder = orderRepository.findOne(order.getOrderId());
    assertThat(insertedOrder, notNullValue());
    String[] excludedFields = {"lineItems", "billingAddress", "shippingAddress", "paymentInfo"};
    assertThat(reflectionEquals(insertedOrder, order, excludedFields), is(true));
    assertThat(reflectionEquals(
        insertedOrder.getBillingAddress(), order.getBillingAddress()), is(true));
    assertThat(reflectionEquals(
        insertedOrder.getShippingAddress(), order.getShippingAddress()), is(true));
    assertThat(reflectionEquals(insertedOrder.getPaymentInfo(), order.getPaymentInfo()), is(true));
    assertThat(reflectionEquals(
        insertedOrder.getLineItems().get(0), order.getLineItems().get(0)), is(true));
  }

  @Test
  public void findByUsername_existingOrder_fetchedOrderForSpecifiedUsername() throws Exception {
    // given
    orderRepository.save(createOrder(1001));
    // when
    List<Order> orders = orderRepository.findByUsername(USERNAME);
    // then
    orders.forEach(order -> assertThat(order.getUsername(), is(USERNAME)));
  }

  private Order createOrder(int orderId) {

    Cart cart = new Cart();
    Item item = itemRepository.findOne(ITEM_ID);
    cart.addItem(item, true);
    Account account = accountRepository.findOne(USERNAME);

    Order order = new Order();
    order.setOrderId(new BigInteger(String.valueOf(orderId)));
    order.initOrder(account, cart);
    return order;
  }

}
