package model;

import com.sun.org.apache.xpath.internal.operations.Bool;
import main.model.exceptions.WrongCuilException;

import java.util.*;

public class Cuil {

  private Long number;

  private List<String> cuilStars = new ArrayList<String>();
  private List<String> cuilEnds  = new ArrayList<String>();

  public Cuil(Long number) {
    this.cuilStars.add("20");
    this.cuilStars.add("21");
    this.cuilStars.add("23");
    this.cuilStars.add("27");

    this.cuilEnds.add("1");
    this.cuilEnds.add("0");

    if(!isValid(number))
      throw new WrongCuilException();

    this.number = number;
  }

  public boolean isValid(Long cuilNumber) {
    return hasTheRightLength(cuilNumber) &&
      hasTheRightStart(cuilNumber) &&
      hasTheRightEnd(cuilNumber);
  }

  private boolean hasTheRightEnd(Long cuilNumber) {
    String s = cuilNumber.toString();
    Integer slen = s.length();
    return this.cuilStars.contains(s.substring(slen-1));
  }

  private boolean hasTheRightStart(Long cuilNumber) {
    return this.cuilStars.contains(cuilNumber.toString().substring(0,2));
  }

  private boolean hasTheRightLength(Long cuilNumber) {
    return cuilNumber.toString().length() != 11;
  }

}
