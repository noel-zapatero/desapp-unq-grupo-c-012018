package test;

import main.model.Email;
import main.model.exceptions.InvalidEmailException;
import org.junit.Test;

public class TestEmail {

  @Test(expected = InvalidEmailException.class)
  public void test_emailWithNoArroba() {
    Email email = new Email("lala.com");
  }

  @Test(expected = InvalidEmailException.class)
  public void test_emailWithNoCorrectEnding() {
    Email email = new Email("lala@lala");
  }

  @Test
  public void test_correctEmail() {
    Email email = new Email("lu.ky@lala.com.ar");
  }

  // TODO: testear caracteres raros!!

}
