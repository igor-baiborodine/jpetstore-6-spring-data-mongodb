package org.mybatis.jpetstore.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.jpetstore.JPetStoreDemo6SpringBootApplication;
import org.mybatis.jpetstore.domain.Address;
import org.mybatis.jpetstore.domain.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigInteger;

/**
 * @author Igor Baiborodine
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JPetStoreDemo6SpringBootApplication.class)
public class SupplierRepositoryPersistenceTest {

  @Autowired
  private SupplierRepository supplierRepository;

  @Test
  public void count_repositoryPopulator_countedTwoSuppliers() {
    // given
    //   repository was populated during the app init
    // when
    long count = supplierRepository.count();
    // then
    assertThat(count, is(2L));
  }

  @Test
  public void findOne_repositoryPopulator_fetchedSupplierWithSpecificCategoryId() {
    // given
    //   repository was populated during the app init
    // when
    BigInteger supplierId = new BigInteger("1");
    Supplier supplier = supplierRepository.findOne(supplierId);
    // then
    assertThat(supplier, notNullValue());
    assertThat(supplier.getSupplierId(), is(supplierId));
    assertThat(supplier.getName(), is("ABC Pets"));

    Address address = supplier.getAddress();
    assertThat(address, notNullValue());
    assertThat(address.getAddress1(), is("600 Avon Way"));
    assertThat(address.getAddress2(), nullValue());
    assertThat(address.getCity(), is("Los Angeles"));
    assertThat(address.getState(), is("CA"));
    assertThat(address.getZip(), is("94024"));
    assertThat(address.getCountry(), is("USA"));
    assertThat(address.getPhone(), is("212-947-0797"));
 }

}