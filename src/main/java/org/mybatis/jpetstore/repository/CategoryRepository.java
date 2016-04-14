package org.mybatis.jpetstore.repository;

import org.mybatis.jpetstore.domain.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Igor Baiborodine
 */
public interface CategoryRepository extends CrudRepository<Category, String> {
}
