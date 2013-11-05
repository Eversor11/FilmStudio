
package filmstudio.movies;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TitleGeneratorTest {
    
    TitleGenerator titleGenerator;
    
    @Before
    public void setUp() {
        titleGenerator = new TitleGenerator();
    }
    
    @Test
    public void titleGeneratedCorrectly(){
        String title = titleGenerator.generateTitle("test/filmstudio/movies/test-adjective.txt", 
                                                    "test/filmstudio/movies/test-noun.txt");
        
        assertTrue(title.equals("adjective noun") || title.equals("The noun"));
    }

}
