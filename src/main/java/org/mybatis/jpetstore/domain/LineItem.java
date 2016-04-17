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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import com.google.common.base.MoreObjects;

import java.math.BigDecimal;

/**
 * @author Eduardo Macarron
 * @author Igor Baiborodine
 */
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class LineItem {

  @NonNull  private Integer lineNumber;
  @NonNull  private Item item;

  private Integer quantity;
  private BigDecimal unitPrice;
  private BigDecimal total;

  public LineItem(Integer lineNumber, CartItem cartItem) {
    this.lineNumber = lineNumber;
    this.quantity = cartItem.getQuantity();
    setItem(cartItem.getItem());
  }

  public void setItem(Item item) {
    this.item = item;
    this.unitPrice = item.getListPrice();
    this.total = (quantity == null || unitPrice == null)
        ? null : unitPrice.multiply(new BigDecimal(quantity));
  }

  public String getItemId() {
    return item.getItemId();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("lineNumber", lineNumber)
        .add("itemId", item.getItemId())
        .add("quantity", quantity)
        .add("unitPrice", unitPrice)
        .add("total", total)
        .toString();
  }

}
