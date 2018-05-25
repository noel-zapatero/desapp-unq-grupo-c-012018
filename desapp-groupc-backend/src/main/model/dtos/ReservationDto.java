package main.model.dtos;

import main.model.Reservation;
import main.model.builders.ReservationBuilder;
import org.joda.time.DateTime;

public class ReservationDto {
  private int reservationId;
  private DateTime start;
  private DateTime end;

  // razones del dto
  private int userId;
  private int publicationId;

  public ReservationDto() { }

  public ReservationDto(Reservation r) {
    this.reservationId = r.getId();
    this.start = r.getStartDate();
    this.end = r.getEndDate();
    this.userId = r.getUser().getId();
    this.publicationId = r.getPublication().getId();
  }

  public int getReservationId() {
    return reservationId;
  }

  public void setReservationId(int reservationId) {
    this.reservationId = reservationId;
  }

  public DateTime getStart() {
    return start;
  }

  public void setStart(DateTime start) {
    this.start = start;
  }

  public DateTime getEnd() {
    return end;
  }

  public void setEnd(DateTime end) {
    this.end = end;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getPublicationId() {
    return publicationId;
  }

  public void setPublicationId(int publicationId) {
    this.publicationId = publicationId;
  }
}
