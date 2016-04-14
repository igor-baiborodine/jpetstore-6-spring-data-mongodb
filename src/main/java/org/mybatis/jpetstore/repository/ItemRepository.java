package org.mybatis.jpetstore.repository;

import org.mybatis.jpetstore.domain.Item;
import org.mybatis.jpetstore.domain.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Igor Baiborodine
 */
public interface ItemRepository extends CrudRepository<Item, String> {

  Iterable<Item> findByProduct(Product product);

}
