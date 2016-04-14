/*
 *    Copyright 2010-2013 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.mybatis.jpetstore.service;

import org.mybatis.jpetstore.domain.Account;
import org.mybatis.jpetstore.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Eduardo Macarron
 * @author Igor Baiborodine
 */
public class AccountService {

  @Autowired  private AccountRepository accountRepository;

  public Account getAccount(String username) {
    return accountRepository.findOne(username);
  }

  public Account getAccount(String username, String password) {
    return accountRepository.findByUsernameAndPassword(username, password);
  }

  public void insertAccount(Account account) {
    accountRepository.save(account);
  }

  public void updateAccount(Account account) {
    accountRepository.save(account);
  }

}
