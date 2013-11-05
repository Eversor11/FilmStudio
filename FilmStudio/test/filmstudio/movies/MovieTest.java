
package filmstudio.movies;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class MovieTest {

    Movie movie;
    
    @Before
    public void setUp() {
        movie = new Movie("Bad Grandpa", 2013, "Comedy", 7.0);
    }
    
    @Test
    public void toStringDisplaysCorrectly(){
        assertEquals("Bad Grandpa (2013) Comedy 7.0/10", movie.toString());
    }


}
