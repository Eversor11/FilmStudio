
package filmstudio.persons;

import filmstudio.utilities.FileReader;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonCreatorTest {
    
    FileReader fileReader;
    Random random;
    PersonCreator personCreator;
    Person randomPerson;
    
    @Before
    public void setUp() throws Exception {
        fileReader = new FileReader();
        random = new Random(1);
        personCreator = new PersonCreator(fileReader, random);
        randomPerson = personCreator.newRandom(1);
    }
    
    @Test
    public void randomPersonGenderCorrectlyGenerated(){
        assertEquals("Male", randomPerson.getGender());
    }
    
    @Test
    public void randomPersonFirstNameCorrectlyGenerated(){
        assertEquals("Walton", randomPerson.getFirstName());
    }
    
    @Test
    public void randomPersonSurnameCorrectlyGenerated(){
        assertEquals("Jordan", randomPerson.getSurname());
    }
    
    @Test
    public void randomPersonAgeCorrectlyGenerated(){
        assertEquals(26, randomPerson.getAge());
    }

}
