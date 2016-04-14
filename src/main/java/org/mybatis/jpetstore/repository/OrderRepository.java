package org.mybatis.jpetstore.repository;

import org.mybatis.jpetstore.domain.Order;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Igor Baiborodine
 */
public interface OrderRepository extends CrudRepository<Order, BigInteger> {

  List<Order> findByUsername(String username);
}
