package org.mybatis.jpetstore.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.jpetstore.JPetStoreDemo6SpringBootApplication;
import org.mybatis.jpetstore.domain.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Igor Baiborodine
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JPetStoreDemo6SpringBootApplication.class)
public class SequenceRepositoryPersistenceTest {

  @Autowired
  private SequenceRepository sequenceRepository;

  @Test
  public void count_repositoryPopulator_countedOneSequence() {
    // given
    //   repository was populated during the app init
    // when
    long count = sequenceRepository.count();
    // then
    assertThat(count, is(1L));
  }

  @Test
  public void findOne_repositoryPopulator_fetchedSequenceWithSpecifiedName() {
    // given
    //   repository was populated during the app init
    // when
    String name = "order";
    Sequence sequence = sequenceRepository.findOne(name);
    // then
    assertThat(sequence, notNullValue());
    assertThat(sequence.getNextId().intValue(), is(1000));
  }

}