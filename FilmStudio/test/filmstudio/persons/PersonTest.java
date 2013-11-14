package filmstudio.persons;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {

    Person person;

    @Before
    public void setUp() {
        person = new Person("Male", "Arnold", "Donitsi", 42);
        person.addFameToPosition("Director", 0);
    }

    @Test
    public void toStringDisplaysCorrectly() {
        assertEquals("Arnold Donitsi\nGender: Male\nAge: 42\n{Director=0}", person.toString());
    }

    @Test
    public void fameAddedCorrectlyToExistingPosition() {
        person.addFameToPosition("Director", 10);
        assertEquals("Arnold Donitsi\nGender: Male\nAge: 42\n{Director=10}", person.toString());
    }

    @Test
    public void positionalFameNeverBelowZero() {
        person.addFameToPosition("Director", 10);
        person.addFameToPosition("Director", -20);
        assertEquals("Arnold Donitsi\nGender: Male\nAge: 42\n{Director=0}", person.toString());
    }

    @Test
    public void getPositionWithMostFame() {
        person.addFameToPosition("Screenwriter", 10);
        person.addFameToPosition("Lead Actor", 20);
        assertEquals("Lead Actor", person.getPosition());
    }
}
