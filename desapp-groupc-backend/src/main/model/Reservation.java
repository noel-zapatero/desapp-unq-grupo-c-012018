package main.model;

import org.joda.time.DateTime;
import org.joda.time.Interval;

public class Reservation {

  private final DateTime start;
  private final DateTime end;
  private final String username;
  private final Publication publication;

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
    return new Interval(this.start, this.end).overlaps(new Interval(start, end));
  }
}
