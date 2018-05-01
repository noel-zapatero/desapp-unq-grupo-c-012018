package test;

import main.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:applicationContext.xml" })
public class TestHibernateSpring {

  @Autowired
  private UserRepository userRepository;

  public void setUserRepository(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Test
  public void test_userBasicPersistence() {

  }
}
