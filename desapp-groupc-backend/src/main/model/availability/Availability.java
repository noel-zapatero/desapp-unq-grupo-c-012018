package main.model.availability;

import org.joda.time.DateTime;

public interface Availability {

    boolean isAvailable(DateTime dateTime);

}
