package main.model.availability;

import org.joda.time.DateTime;

public class RangeAvailability implements Availability {
    DateTime start;
    DateTime end;

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
        return dateTime.isAfter(start) && dateTime.isBefore(end);
    }
}
