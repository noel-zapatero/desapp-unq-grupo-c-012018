package main.model;

import org.joda.time.DateTime;

public class Availability {

  private DateTime start;
  private DateTime end;

  public Availability(DateTime start, DateTime end) {
    this.start = start;
    this.end = end;
  }

  public boolean isAvailable(DateTime start, DateTime end) {
    if (this.start == null || this.end == null) //TODO: refactorizar esta villereada!!
      return false;

    return this.start.isBefore(start) && this.end.plusMinutes(1).isAfter(end);
  }
}
