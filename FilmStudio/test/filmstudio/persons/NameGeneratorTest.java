package filmstudio.persons;

import filmstudio.utilities.FileReader;
import java.io.File;
import java.util.List;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NameGeneratorTest {

    FileReader fileReader;
    Random random1;
    Random random2;
    Random random3;
    Random random4;
    NameGenerator nameGenerator1;
    NameGenerator nameGenerator2;
    NameGenerator nameGenerator3;
    NameGenerator nameGenerator4;
    List<String> test;
    
    /* Päädyin käyttämään seedattua randomia mockauksen sijaan, koska
     * haluan selvitä ilman ulkopuolisia kirjastoja
     */

    @Before
    public void setUp() throws Exception {
        fileReader = new FileReader();
        random1 = new Random(2);
        random2 = new Random(3);
        random3 = new Random(4);
        random4 = new Random(1);
        nameGenerator1 = new NameGenerator(random1);
        nameGenerator2 = new NameGenerator(random2);
        nameGenerator3 = new NameGenerator(random3);
        nameGenerator4 = new NameGenerator(random4);
        test = fileReader.readFile("resources"+File.separator+
                                   "persons"+File.separator+
                                   "test.txt");
    }
    
    @Test
    public void nameGeneratedCorrectly1(){
        assertEquals("first", nameGenerator1.generateName(test, 1, 2, 3));
    }
    
    @Test
    public void nameGeneratedCorrectly2(){
        assertEquals("second", nameGenerator2.generateName(test, 1, 2, 3));
    }
    
    @Test
    public void nameGeneratedCorrectly3(){
        assertEquals("third", nameGenerator3.generateName(test, 1, 2, 3));
    }
    
    @Test
    public void nameGeneratedCorrectly4(){
        assertEquals("fourth", nameGenerator4.generateName(test, 1, 2, 3));
    }
    
    
}
