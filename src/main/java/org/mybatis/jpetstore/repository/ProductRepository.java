package org.mybatis.jpetstore.repository;

import org.mybatis.jpetstore.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Igor Baiborodine
 */
public interface ProductRepository extends CrudRepository<Product, String> {

  List<Product> findByCategoryId(String categoryId);

  // TODO: implement full-text search
  //List<Product> searchProductList(String keywords);

}
