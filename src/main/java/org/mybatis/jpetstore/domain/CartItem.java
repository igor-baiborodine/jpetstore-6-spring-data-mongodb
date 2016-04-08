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

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import com.google.common.base.MoreObjects;

import java.math.BigDecimal;

/**
 * @author Eduardo Macarron
 * @author Igor Baiborodine
 */
@Getter
public class CartItem {

  @NonNull  private Item item;
  @NonNull  private Integer quantity;
  @Setter   private boolean inStock;
  @NonNull  private BigDecimal total;

  public void setItem(Item item) {
    this.item = item;
    calculateTotal();
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
    calculateTotal();
  }

  public void incrementQuantity() {
    quantity++;
    calculateTotal();
  }

  private void calculateTotal() {
    if (item != null && item.getListPrice() != null) {
      total = item.getListPrice().multiply(new BigDecimal(quantity));
    } else {
      total = null;
    }
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("item", item)
        .add("quantity", quantity)
        .add("inStock", inStock)
        .add("total", total)
        .toString();
  }

}
