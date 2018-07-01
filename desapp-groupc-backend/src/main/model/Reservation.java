package main.model;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.Interval;

import javax.persistence.*;

@Entity
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int reservationId;

  @Column
  private boolean accepted = false;

  @Column
  @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
  private DateTime start;

  @Column
  @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
  private DateTime end;

  @OneToOne
  private User user;

  @OneToOne
  private Publication publication;

  public Reservation() { }

  public Reservation(DateTime start, DateTime end, User username, Publication publication) {
    this.start = start;
    this.end = end;
    this.user = username;
    this.publication = publication;
  }

  public void accept() {
    this.accepted = true;
    this.publication.acceptReservation(this);
  }

  /**
   *
   * @param start
   * @param end
   * @return si esta reserva coincide con el periodo de start a end
   */
  public boolean conflictsWith(DateTime start, DateTime end) {
    return this.overlaps(new Interval(start, end));
  }

  public boolean overlaps(Interval interval) {
    return this.asInterval().overlaps(interval);
  }

  public Interval asInterval() {
    return new Interval(this.start, this.end);
  }

  public int getId() {
    return this.reservationId;
  }

  public User getUser() {
    return this.user;
  }

  public DateTime getStartDate() {
    return start;
  }

  public DateTime getEndDate() {
    return end;
  }

  public Publication getPublication() {
    return publication;
  }

  public void setReservationId(int reservationId) {
    this.reservationId = reservationId;
  }

  public void setStart(DateTime start) {
    this.start = start;
  }

  public void setEnd(DateTime end) {
    this.end = end;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void setPublication(Publication publication) {
    this.publication = publication;
  }

  public boolean getAccepted() {
    return accepted;
  }

  public int getReservationId() {
    return reservationId;
  }

  public boolean isAccepted() {
    return accepted;
  }

  public void setAccepted(boolean accepted) {
    this.accepted = accepted;
  }

  public DateTime getStart() {
    return start;
  }

  public DateTime getEnd() {
    return end;
  }

  public String getUserEmail() {
    return this.user.email;
  }
}
