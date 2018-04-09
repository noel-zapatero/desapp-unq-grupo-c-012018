package test;

import junit.framework.TestCase;
import main.model.Publication;
import main.model.User;
import main.model.Vehicle;
import main.model.builders.PublicationBuilder;
import main.model.builders.UserBuilder;

public class TestUser extends TestCase {

    public void testCreateUser(){
        User burns = new UserBuilder()
                .withCuil(30000000011L)
                .withNameAndLastName("Montgomery", "Burns")
                .withAddress("Fake Street 123")
                .withEmail("mburns@springfield.com")
                .build();

        assert(burns.getName()).equals("Montgomery");
    }

    public void testChargeAndWithdrawCredits(){
        User newUser = new UserBuilder().build();

        newUser.chargeCredits(100);
        assertTrue(newUser.getCredits() == 100);
        newUser.whitdrawCredits(25);
        assertTrue(newUser.getCredits() == 75);
    }

    public void testReceiveRating(){
        User newUser = new UserBuilder().build();

        assertTrue(newUser.getRating() == 0);
        newUser.receiveRating(5);
        assertTrue(newUser.getRating() == 5);
        newUser.receiveRating(3);
        assertTrue(newUser.getRating() == 4);
        newUser.receiveRating(3);
        assertTrue(newUser.getRating() == 3.67);
    }

    public void testBookingVehicle(){
      User newUser = new UserBuilder()
        .withEmail("witherwings77@gmail.com")
        .withNameAndLastName("Noel", "Zapatero")
        .build();
      Publication pub = new PublicationBuilder()
        .withVehicle(new Vehicle())
        .withOwner(newUser)
        .build();

      //newUser.bookVehicle(pub);
    }

}
