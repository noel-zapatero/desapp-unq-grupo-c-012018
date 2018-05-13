package main.model;

import main.model.exceptions.InvalidEmailException;

import java.util.ArrayList;
import java.util.List;

public class Email {

  private String address;

  private List<String> endings = new ArrayList<String>();

  public Email(String adress) {
    this.endings.add(".com");
    this.endings.add(".org");
    this.endings.add(".net");
    this.endings.add(".com.ar");

    if (!this.isValid(adress))
      throw new InvalidEmailException();

    this.address = adress;
  }

  private boolean isValid(String adress) {
    return hasArroba(adress) &&
      hasCorrectEnding(adress);
  }

  private boolean hasCorrectEnding(String adress) {
    boolean ret = false;

    for (String ending : this.endings)
      ret = ret || adress.endsWith(ending);

    return ret;
  }

  private boolean hasArroba(String adress) {
    return adress.contains("@");
  }

  public String getAddress() {
    return address;
  }
}
