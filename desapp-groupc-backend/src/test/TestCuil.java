package test;

import main.model.exceptions.WrongCuilException;
import model.Cuil;
import org.junit.Test;

public class TestCuil {

  @Test(expected = WrongCuilException.class)
  public void test_seeThatICantCreateACuildWithTheWrongLenght() {
    Cuil cuil = new Cuil(203377788811L);
  }

  @Test(expected = WrongCuilException.class)
  public void test_seeThatICantCreateACuildWithTheWrongLenght_V2() {
    Cuil cuil = new Cuil(2033777888L);
  }

  // arrancan con 20, 27, 23, 21

  @Test(expected = WrongCuilException.class)
  public void test_wrongCuilStart() {
    Cuil cuil = new Cuil(40337778881L);
  }

  @Test(expected = WrongCuilException.class)
  public void test_wrongCuilEnd() {
    Cuil cuil = new Cuil(20337778881L);
  }

}
