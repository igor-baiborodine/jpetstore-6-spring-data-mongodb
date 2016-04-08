package org.mybatis.jpetstore.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import com.google.common.base.MoreObjects;

/**
 * @author Igor Baiborodine
 */
@Getter @Setter @Builder
@NoArgsConstructor
public class Address {

  @NonNull  private String address1;
            private String address2;
  @NonNull  private String city;
  @NonNull  private String state;
  @NonNull  private String zip;
  @NonNull  private String country;
  @NonNull  private String phone;

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("address1", address1)
        .add("address2", address2)
        .add("city", city)
        .add("state", state)
        .add("zip", zip)
        .add("country", country)
        .add("phone", phone)
        .toString();
  }

}
