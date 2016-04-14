package org.mybatis.jpetstore.repository;

import org.mybatis.jpetstore.domain.Supplier;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

/**
 * @author Igor Baiborodine
 */
public interface SupplierRepository extends CrudRepository<Supplier, BigInteger> {
}
