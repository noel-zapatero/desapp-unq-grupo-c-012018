package main.model.availability;

import org.joda.time.DateTime;

public class NotAvailable implements Availability {

  public boolean isAvailable(DateTime start, DateTime end) {
    return false;
  }

}
