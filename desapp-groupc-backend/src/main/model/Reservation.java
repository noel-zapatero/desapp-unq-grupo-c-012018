package main.model;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;
  @Column(name = "start")
  private DateTime start;
  @Column(name = "end")
  private DateTime end;
  //TODO: Chequear si no deberia ser un User, y hacer join
  @Column(name = "username")
  private String username;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinTable(name = "publications")
  private Publication publication;

  public Reservation(DateTime start, DateTime end, String username, Publication publication) {
    this.start = start;
    this.end = end;
    this.username = username;
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
}
