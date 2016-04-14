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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Eduardo Macarron
 * @author Igor Baiborodine
 */
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@Document
public class Item {

  @Id       private String itemId;
  @NonNull  private Product product;
  @NonNull  private BigInteger supplierId;
  @NonNull  private BigDecimal listPrice;
  @NonNull  private BigDecimal unitCost;
  @NonNull  private String status;
  @NonNull  private Integer quantity;

  private String attribute1;
  private String attribute2;
  private String attribute3;
  private String attribute4;
  private String attribute5;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Item item = (Item) o;
    return Objects.equal(itemId, item.itemId);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(itemId);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("itemId", itemId)
        .add("productId", product.getProductId())
        .add("listPrice", listPrice)
        .add("unitCost", unitCost)
        .add("supplierId", supplierId)
        .add("status", status)
        .add("quantity", quantity)
        .toString();
  }

}
