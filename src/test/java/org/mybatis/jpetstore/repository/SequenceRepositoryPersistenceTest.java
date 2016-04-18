package org.mybatis.jpetstore.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.jpetstore.AbstractIntegrationTest;
import org.mybatis.jpetstore.JPetStoreDemo6SpringBootApplication;
import org.mybatis.jpetstore.domain.Order;
import org.mybatis.jpetstore.domain.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Igor Baiborodine
 */
public class SequenceRepositoryPersistenceTest extends AbstractIntegrationTest {

  @Autowired private SequenceRepository sequenceRepository;

  @Test
  public void count_repositoryPopulated_countedOneSequence() {
    // given
    //   repository was populated during the app init
    // when
    long count = sequenceRepository.count();
    // then
    assertThat(count, is(1L));
  }

  @Test
  public void findOne_repositoryPopulated_fetchedSequenceWithSpecifiedName() {
    // given
    //   repository was populated during the app init
    // when
    Sequence sequence = sequenceRepository.findOne(Order.SEQUENCE_NAME);
    // then
    assertThat(sequence, notNullValue());
    assertThat(sequence.getNextId().intValue(), is(1000));
  }

}