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
import com.google.common.base.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Eduardo Macarron
 * @author Igor Baiborodine
 */
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Document
public class Category {

  @Id       private String categoryId;
  @NonNull  private String name;
  @NonNull  private String description;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Category category = (Category) o;
    return Objects.equal(categoryId, category.categoryId);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(categoryId);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("categoryId", categoryId)
        .add("name", name)
        .add("description", description)
        .toString();
  }

}
