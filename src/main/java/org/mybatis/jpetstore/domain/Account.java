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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Igor Baiborodine
 */
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@Document
public class Account {

  @Id       private String username;
  @NonNull  private String password;
  @NonNull  private String email;
  @NonNull  private String firstName;
  @NonNull  private String lastName;
  @NonNull  private String status;
  @NonNull  private Address address;
  @NonNull  private Profile profile;

  public boolean isBannerOption() {
    return profile != null && profile.isBannerOption();
  }

  public String getBannerName() {
    return profile != null ? profile.getBannerName() : null;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Account account = (Account) o;
    return Objects.equal(username, account.username);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(username);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("username", username)
        .add("password", password)
        .add("email", email)
        .add("firstName", firstName)
        .add("lastName", lastName)
        .add("status", status)
        .toString();
  }

}
