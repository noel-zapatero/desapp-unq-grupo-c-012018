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
  @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
  private DateTime start;

  @Column
  @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
  private DateTime end;

  //TODO: Chequear si no deberia ser un User, y hacer join
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
}
