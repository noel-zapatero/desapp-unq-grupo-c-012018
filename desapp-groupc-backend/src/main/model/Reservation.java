package main.model;

import org.joda.time.DateTime;
import org.joda.time.Interval;

public class Reservation {

  private DateTime start;
  private DateTime end;
  private String username;
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
