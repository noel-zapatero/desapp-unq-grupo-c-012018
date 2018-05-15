package main.model;

import main.model.exceptions.WrongCuilException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cuil")
public class Cuil {

  @Id
  @Column
  private Long number;

  @Transient
  private List<String> cuilStarts = new ArrayList<String>();

  @Transient
  private List<String> cuilEnds  = new ArrayList<String>();

  public Cuil(Long number) {
    this.cuilStarts.add("20");
    this.cuilStarts.add("21");
    this.cuilStarts.add("23");
    this.cuilStarts.add("27");

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
    String tmp = s.substring(slen-1);
    boolean b = this.cuilEnds.contains(s.substring(slen-1));
    return b;
  }

  private boolean hasTheRightStart(Long cuilNumber) {
    return this.cuilStarts.contains(cuilNumber.toString().substring(0,2));
  }

  private boolean hasTheRightLength(Long cuilNumber) {
    return cuilNumber.toString().length() == 11;
  }

  public long getValue() {
    return number;
  }
}
