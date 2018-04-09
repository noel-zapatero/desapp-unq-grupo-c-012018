package main.model.availability;

import org.joda.time.DateTime;

public class Available implements Availability {

  private DateTime start;
  private DateTime end;

  public Available(DateTime start, DateTime end) {
    this.start = start;
    this.end = end;
  }

  public boolean isAvailable(DateTime start, DateTime end) {
    if (this.start == null || this.end == null) //TODO: refactorizar esta villereada!!
      return false;

    return this.isBeforeOrAtTheSameTime(start) && this.end.plusMinutes(1).isAfter(end);
  }

  private boolean isBeforeOrAtTheSameTime(DateTime dateTime) {
    return this.start.isBefore(dateTime.plusMinutes(1));
  }
}
