package org.mybatis.jpetstore.repository;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.jpetstore.JPetStoreDemo6SpringBootApplication;
import org.mybatis.jpetstore.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Igor Baiborodine
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JPetStoreDemo6SpringBootApplication.class)
public class CategoryRepositoryPersistenceTest {

  public static final String CATEGORY_ID = "CATEGORY_ID";
  public static final String NAME = "Dinosaurs";
  public static final String DESCRIPTION = "Lovely and Tender Dinosaurs";

  @Autowired
  private CategoryRepository categoryRepository;

  @Test
  public void count_repositoryPopulator_countedFiveCategories() {
    // given
    //   repository was populated during the app init
    // when
    long count = categoryRepository.count();
    // then
    assertThat(count, is(5L));
  }

  @Test
  public void findOne_repositoryPopulator_fetchedCategoryWithSpecificCategoryId() {
    // given
    //   repository was populated during the app init
    // when
    Category category = categoryRepository.findOne("CATS");
    // then
    assertThat(category, notNullValue());
    assertThat(category.getCategoryId(), is("CATS"));
    assertThat(category.getName(), is("Cats"));
    assertThat(category.getDescription(), is("<image src='../images/cats_icon.gif'><font size='5' color='blue'> Cats</font>"));
  }

  @Test
  public void save_newCategory_inserted() {
    // given
    Category category = new Category(CATEGORY_ID, NAME, DESCRIPTION);
    // when
    Category savedCategory = categoryRepository.save(category);
    // then
    assertThat(savedCategory, notNullValue());
    assertThat(savedCategory, sameInstance(category));
    assertThat(savedCategory.getCategoryId(), is(CATEGORY_ID));
    assertThat(savedCategory.getName(), is(NAME));
    assertThat(savedCategory.getDescription(), is(DESCRIPTION));
  }

  @Test
  public void save_existingCategory_updated() {
    // given
    String categoryId = "DOGS";
    Category category = categoryRepository.findOne(categoryId);
    assertThat(category, notNullValue());
    // when
    category.setName(NAME);
    category.setDescription(DESCRIPTION);
    Category savedCategory = categoryRepository.save(category);
    // then
    assertThat(savedCategory, notNullValue());
    assertThat(savedCategory, sameInstance(category));
    assertThat(savedCategory.getCategoryId(), is(categoryId));
    assertThat(savedCategory.getName(), is(NAME));
    assertThat(savedCategory.getDescription(), is(DESCRIPTION));
  }

}