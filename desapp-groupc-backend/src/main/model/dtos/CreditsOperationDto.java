package main.model.dtos;

public class CreditsOperationDto {
  public String userEmail;
  public int credits;

  public CreditsOperationDto(String userEmail, int credits) {
    this.userEmail = userEmail;
    this.credits = credits;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public int getCredits() {
    return credits;
  }

  public void setCredits(int credits) {
    this.credits = credits;
  }
}
