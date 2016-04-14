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

import java.math.BigInteger;

/**
 * @author Igor Baiborodine
 */
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@Document
public class Supplier {

  @Id       private BigInteger supplierId;
  @NonNull  private String name;
  @NonNull  private String status;
  @NonNull  private Address address;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Supplier supplier = (Supplier) o;
    return Objects.equal(supplierId, supplier.supplierId);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(supplierId);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("supplierId", supplierId)
        .add("status", status)
        .add("name", name)
        .add("address", address)
        .toString();
  }

}
