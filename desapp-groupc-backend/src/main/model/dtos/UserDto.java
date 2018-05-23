package main.model.dtos;

import main.model.User;
import main.model.builders.UserBuilder;

public class UserDto {

  private int userId;
  private long cuil;
  private String lastName;
  private String firstName;
  private String adress;
  private String email;
  private double rating;
  private float credits;

  public UserDto() { }

  public UserDto(User user) {
    this.userId = user.getId();
    this.cuil = user.getCuil();
    this.lastName = user.lastName;
    this.firstName = user.firstName;
    this.adress = user.getAdress();
    this.email = user.getEmail();
    this.rating = user.getRating();
    this.credits = user.getCredits();
  }

  public User toUser() {
    return new UserBuilder()
      .withEmail(this.getEmail())
      .withNameAndLastName(this.getFirstName(), this.getLastName())
      .withAddress(this.getAdress())
      .withCuil(this.getCuil())
      .build();
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public long getCuil() {
    return cuil;
  }

  public void setCuil(long cuil) {
    this.cuil = cuil;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getAdress() {
    return adress;
  }

  public void setAdress(String adress) {
    this.adress = adress;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(float rating) {
    this.rating = rating;
  }

  public float getCredits() {
    return credits;
  }

  public void setCredits(float credits) {
    this.credits = credits;
  }

}
