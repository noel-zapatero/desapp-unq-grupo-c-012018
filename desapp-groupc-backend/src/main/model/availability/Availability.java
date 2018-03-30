package main.model.availability;

import org.joda.time.DateTime;

public interface Availability {

  boolean isAvailable(DateTime dateTime);

    boolean isAvailable(DateTime from, DateTime to);

}
