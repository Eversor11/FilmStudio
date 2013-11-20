
package filmstudio.movies;

import filmstudio.utilities.FileReader;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TitleGeneratorTest {
    
    TitleGenerator titleGenerator1;
    TitleGenerator titleGenerator2;
    FileReader fileReader;
    Random random1;
    Random random2;
    
    /* Päädyin käyttämään seedattua randomia mockauksen sijaan, koska
     * haluan selvitä ilman ulkopuolisia kirjastoja
     */
    
    @Before
    public void setUp() {
        fileReader = new FileReader();
        random1 = new Random(1);
        random2 = new Random(10);
        titleGenerator1 = new TitleGenerator(fileReader, random1);
        titleGenerator2 = new TitleGenerator(fileReader, random2);
    }
    
    @Test
    public void title1GeneratedCorrectly() throws Exception {
        String title = titleGenerator1.generateTitle("test/resources/movies/test-adjective.txt", 
                                                     "test/resources/movies/test-noun.txt");
        
        assertEquals("adjective noun", title);
    }
    
    @Test
    public void title2GeneratedCorrectly() throws Exception {
        String title = titleGenerator2.generateTitle("test/resources/movies/test-adjective.txt", 
                                                     "test/resources/movies/test-noun.txt");
        
        assertEquals("The noun", title);
    }

}
