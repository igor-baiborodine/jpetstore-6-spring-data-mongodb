/*
 *    Copyright 2010-2013 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.mybatis.jpetstore.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author Eduardo Macarron
 * @author Igor Baiborodine
 */
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@Document
public class Order {

  public static final String SEQUENCE_NAME = "order";

  @Id       private BigInteger orderId;
  @NonNull  private String username;
  @NonNull  private Date orderDate;

  @NonNull  private BigDecimal totalPrice;
  @NonNull  private String locale;
  @NonNull  private String status;

  @NonNull  private String billingFirstName;
  @NonNull  private String billingLastName;
  @NonNull  private Address billingAddress;

  @NonNull  private String shippingFirstName;
  @NonNull  private String shippingLastName;
  @NonNull  private Address shippingAddress;

  @NonNull  private PaymentInfo paymentInfo;
            private String courier;
            private List<LineItem> lineItems = newArrayList();

  public void initOrder(Account account, Cart cart) {

    username = account.getUsername();
    orderDate = new Date();

    shippingFirstName = account.getFirstName();
    shippingLastName = account.getLastName();
    shippingAddress = Address.copy(account.getAddress());

    billingFirstName = account.getFirstName();
    billingLastName = account.getLastName();
    billingAddress = Address.copy(account.getAddress());
    paymentInfo = new PaymentInfo();

    totalPrice = cart.getSubTotal();
    courier = "UPS";
    locale = "CA";
    status = "P";

    cart.getAllCartItems().forEachRemaining(cartItem -> {
      LineItem lineItem = new LineItem(lineItems.size() + 1, cartItem);
      lineItems.add(lineItem);
    });
  }

  public String getCreditCard() {
    return paymentInfo != null ? paymentInfo.getCreditCard() : null;
  }

  public String getExpiryDate() {
    return paymentInfo != null ? paymentInfo.getExpiryDate() : null;
  }

  public String getCardType() {
    return paymentInfo != null ? paymentInfo.getCardType() : null;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Order order = (Order) o;
    return Objects.equal(orderId, order.orderId);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(orderId);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("orderId", orderId)
        .add("username", username)
        .add("orderDate", orderDate)
        .add("courier", courier)
        .add("totalPrice", totalPrice)
        .add("locale", locale)
        .add("status", status)
        .add("lineItemsCount", lineItems.size())
        .toString();
  }

}

@Getter @NoArgsConstructor
class PaymentInfo {
  private String creditCard = "999 9999 9999 9999";
  private String expiryDate = "12/03";
  private String cardType = "Visa";
}
