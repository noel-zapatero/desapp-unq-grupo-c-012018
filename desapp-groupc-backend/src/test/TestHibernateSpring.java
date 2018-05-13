package test;

import main.model.User;
import main.model.builders.UserBuilder;
import main.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:applicationContext.xml" })
public class TestHibernateSpring {

  @Autowired
  private UserService userService;

  public void setUserService(final UserService userService) {
    this.userService = userService;
  }

  @Test
  public void test_userBasicPersistence() {
    User u = new UserBuilder()
      .withEmail("l@l.com")
      .withNameAndLastName("Luky", "Lala")
      .withAddress("Fake Street 123")
      .withCuil(20000000001L)
      .build();

    userService.save(u);

    User u2 = userService.findById(u.getId());

    assertEquals(u.getId(), u2.getId());
    assertEquals(u.getRating(), u2.getRating());
    assertEquals(u.getCredits(), u2.getCredits());
    assertEquals(u.getName(), u2.getName());
    assertEquals(u.getEmail(), u2.getEmail());
  }
}
