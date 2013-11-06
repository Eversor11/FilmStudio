
package filmstudio.movies;

import filmstudio.utilities.FileReader;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TitleGeneratorTest {
    
    TitleGenerator titleGenerator;
    FileReader fileReader;
    Random random;
    
    @Before
    public void setUp() {
        fileReader = new FileReader();
        random = new Random(1);
        titleGenerator = new TitleGenerator(fileReader, random);
    }
    
    @Test
    public void title1GeneratedCorrectly() throws Exception {
        String title = titleGenerator.generateTitle("test/filmstudio/movies/test-adjective.txt", 
                                                    "test/filmstudio/movies/test-noun.txt");
        
        assertEquals("adjective noun", title);
    }
    
    @Test
    public void title2GeneratedCorrectly() throws Exception {
        for(int i = 0; i < 13; i++){
            random.nextInt();
        }
        
        String title = titleGenerator.generateTitle("test/filmstudio/movies/test-adjective.txt", 
                                                    "test/filmstudio/movies/test-noun.txt");
        
        assertEquals("The noun", title);
    }

}
