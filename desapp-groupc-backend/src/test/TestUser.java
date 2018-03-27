package test;

import junit.framework.TestCase;
import main.model.User;
import main.model.builders.UserBuilder;

public class TestUser extends TestCase {

    public void testCreateUser(){
        User burns = new UserBuilder()
                .withCuil(000000011)
                .withNameAndLastName("Montgomery", "Burns")
                .withAddress("Fake Street 123")
                .withEmail("mburns@springfield.com")
                .build();

        assertTrue(burns.getName()== "Montgomery");
    }
}
