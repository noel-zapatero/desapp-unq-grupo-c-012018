package main.model.dtos;

import main.model.Reservation;
import main.model.builders.ReservationBuilder;
import org.joda.time.DateTime;

public class ReservationDto {
  public int reservationId;
  public boolean accepted;

  //start
  public int startYear;
  public int startMonth;
  public int startDayOfMonth;

  //end
  public int endYear;
  public int endMonth;
  public int endDayOfMonth;

  // razones del dto
  public String userEmail;
  public int publicationId;

  public ReservationDto() { }

  public ReservationDto(Reservation r) {
    this.reservationId = r.getId();

    this.startYear = r.getStart().getYear();
    this.startMonth = r.getStart().getMonthOfYear();
    this.startDayOfMonth = r.getStart().getDayOfMonth();

    this.endYear = r.getEnd().getYear();
    this.endMonth = r.getEnd().getMonthOfYear();
    this.endDayOfMonth = r .getEnd().getDayOfMonth();

    this.userEmail = r.getUserEmail();
    this.publicationId = r.getPublication().getId();
    this.accepted = r.getAccepted();
  }

  public int getReservationId() {
    return reservationId;
  }

  public void setReservationId(int reservationId) {
    this.reservationId = reservationId;
  }

  public int getStartYear() {
    return startYear;
  }

  public void setStartYear(int startYear) {
    this.startYear = startYear;
  }

  public int getStartMonth() {
    return startMonth;
  }

  public void setStartMonth(int startMonth) {
    this.startMonth = startMonth;
  }

  public int getStartDayOfMonth() {
    return startDayOfMonth;
  }

  public void setStartDayOfMonth(int startDayOfMonth) {
    this.startDayOfMonth = startDayOfMonth;
  }

  public int getEndYear() {
    return endYear;
  }

  public void setEndYear(int endYear) {
    this.endYear = endYear;
  }

  public int getEndMonth() {
    return endMonth;
  }

  public void setEndMonth(int endMonth) {
    this.endMonth = endMonth;
  }

  public int getEndDayOfMonth() {
    return endDayOfMonth;
  }

  public void setEndDayOfMonth(int endDayOfMonth) {
    this.endDayOfMonth = endDayOfMonth;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public int getPublicationId() {
    return publicationId;
  }

  public void setPublicationId(int publicationId) {
    this.publicationId = publicationId;
  }

  public boolean isAccepted() {
    return accepted;
  }

  public void setAccepted(boolean accepted) {
    this.accepted = accepted;
  }
}
