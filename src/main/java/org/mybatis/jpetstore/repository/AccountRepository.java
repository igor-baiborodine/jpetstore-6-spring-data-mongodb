package org.mybatis.jpetstore.repository;

import org.mybatis.jpetstore.domain.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Igor Baiborodine
 */
public interface AccountRepository extends CrudRepository<Account, String> {

  Account findByUsernameAndPassword(String username, String password);
}
