package main.model.availability;

import org.joda.time.DateTime;

public class AllwaysAvailable implements Availability {

  public boolean isAvailable(DateTime dateTime) {
    return true;
  }

  public boolean isAvailable(DateTime from, DateTime to) {
        return true;
    }

}
