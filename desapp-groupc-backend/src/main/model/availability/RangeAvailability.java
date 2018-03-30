package main.model.availability;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;

public class RangeAvailability implements Availability {
    private DateTime start;
    private DateTime end;

    public RangeAvailability(DateTime start, DateTime end) {
        this.start = start;
        this.end = end;
    }

  public DateTime getStart() {
        return start;
    }

    public DateTime getEnd() {
        return end;
    }

  public boolean isAvailable(DateTime dateTime) {
    return this.isAvailable(dateTime, dateTime);
  }

  public boolean isAvailable(DateTime from, DateTime to) {
      return start.isBefore(from) && end.isAfter(to);
    }
}
