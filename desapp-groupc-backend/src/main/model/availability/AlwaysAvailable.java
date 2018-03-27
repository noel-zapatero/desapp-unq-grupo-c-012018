package main.model.availability;

import org.joda.time.DateTime;

public class AlwaysAvailable implements Availability {

    public boolean isAvailable(DateTime dateTime) {
        return true;
    }

}
