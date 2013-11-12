
package filmstudio.persons;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {
    
    Person person;
    
    @Before
    public void setUp() {
        person = new Person("Male", "Arnold", "Donitsi", 42);
    }
    
    @Test
    public void toStringDisplaysCorrectly(){
        assertEquals("Arnold Donitsi\nGender: Male\nAge: 42", person.toString());
    }

}
