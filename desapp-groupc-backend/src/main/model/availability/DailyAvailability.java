package main.model.availability;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;

public class DailyAvailability implements Availability {
  private LocalTime start;
  private LocalTime end;

  public DailyAvailability(LocalTime start, LocalTime end) {
    this.start = start;
    this.end = end;
  }

  public boolean isAvailable(DateTime dateTime) {
    return this.isAvailable(dateTime, dateTime);
  }

  public boolean isAvailable(DateTime from, DateTime to) {
    return this.isEqualOrBefore(from) && end.isAfter(to.toLocalTime());
  }

  private boolean isEqualOrBefore(DateTime dateTime) {
    LocalTime localTime = dateTime.toLocalTime();
    return start.isBefore(localTime) || start.isEqual(localTime);
  }
}
