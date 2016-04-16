package org.mybatis.jpetstore.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.jpetstore.JPetStoreDemo6SpringBootApplication;
import org.mybatis.jpetstore.domain.Account;
import org.mybatis.jpetstore.domain.Address;
import org.mybatis.jpetstore.domain.Item;
import org.mybatis.jpetstore.domain.Product;
import org.mybatis.jpetstore.domain.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Igor Baiborodine
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JPetStoreDemo6SpringBootApplication.class)
public class AccountRepositoryPersistenceTest {

  @Autowired
  private AccountRepository accountRepository;

  @Test
  public void count_repositoryPopulator_countedTwoAccounts() {
    // given
    //   repository was populated during the app init
    // when
    long count = accountRepository.count();
    // then
    assertThat(count, is(2L));
  }

  @Test
  public void findOne_repositoryPopulator_fetchedAccountWithSpecifiedUsername() {
    // given
    //   repository was populated during the app init
    // when
    String username = "pfry";
    Account account = accountRepository.findOne(username);
    // then
    assertThat(account, notNullValue());
    assertThat(account.getUsername(), is(username));
    assertThat(account.getPassword(), is("slurm"));
    assertThat(account.getFirstName(), is("Philip"));
    assertThat(account.getLastName(), is("Fry"));
    assertThat(account.getStatus(), is("OK"));
    assertThat(account.getEmail(), is("philip.fry@planet-express.earth"));

    assertThat(EqualsBuilder.reflectionEquals(account.getAddress(), createAddress()), is(true));
    assertThat(EqualsBuilder.reflectionEquals(account.getProfile(), createProfile()), is(true));
  }

  @Test
  public void findByUsernameAndPassword_repositoryPopulator_fetchedAccountWithSpecifiedUsernameAndPassword() {
    // given
    //   repository was populated during the app init
    // when
    String username = "pfry";
    String password = "slurm";
    Account account = accountRepository.findByUsernameAndPassword(username, password);
    // then
    assertThat(account, notNullValue());
    assertThat(account.getUsername(), is(username));
    assertThat(account.getPassword(), is(password));
  }

  private Address createAddress() {
    return Address.builder()
        .address1("101 Robot Arms Ave.")
        .address2("#901")
        .city("New New York City")
        .state("NY")
        .zip("01234")
        .country("Earth")
        .phone("0123456789")
        .build();
  }

  private Profile createProfile() {
    return Profile.builder()
      .favouriteCategoryId("CATS")
        .languagePreference("AL2")
        .listOption(true)
        .bannerOption(true)
        .bannerName("<image src=\"../images/banner_cats.gif\">")
        .build();
  }

}
