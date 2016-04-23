package org.mybatis.jpetstore.config;

import org.junit.Test;
import org.mybatis.jpetstore.AbstractIntegrationTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Igor Baiborodine
 */
@WebIntegrationTest(randomPort=true)
public class HomepageIntegrationTest extends AbstractIntegrationTest {

  @Value("${local.server.port}")
  private int port;

  @Test
  public void homepage_indexHtml_retrievedWithEmptyContextPath() throws Exception {
    ResponseEntity<String> entity = new TestRestTemplate().getForEntity("http://localhost:" + port, String.class);
    assertThat(entity.getStatusCode(), is(HttpStatus.OK));
    assertThat(entity.getBody().contains("<h2>Welcome to JPetStore 6 MongoDB"), is(true));
  }

}
