package org.mybatis.jpetstore.repository;

import org.mybatis.jpetstore.domain.Sequence;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Igor Baiborodine
 */
public interface SequenceRepository extends CrudRepository<Sequence, String> {
}
