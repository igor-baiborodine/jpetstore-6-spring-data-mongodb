package org.mybatis.jpetstore.repository;

import org.mybatis.jpetstore.domain.Product;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Igor Baiborodine
 */
public interface ProductRepository extends CrudRepository<Product, String> {

  List<Product> findByCategoryId(String categoryId);

  List<Product> findAllBy(TextCriteria criteria);

}
