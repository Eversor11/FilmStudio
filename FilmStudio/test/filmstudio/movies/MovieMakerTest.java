
package filmstudio.movies;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class MovieMakerTest {
    
    MovieMaker movieMaker;

    @Before
    public void setUp() {
        movieMaker = new MovieMaker();
    }
    
    @Test
    public void currentYearIsCorrect(){
        assertEquals(Calendar.getInstance().get(Calendar.YEAR), movieMaker.getCurrentYear());
    }
    
    @Test
    public void currentYearIncrementedCorrectly(){
        
        movieMaker.incrementCurrentYear();
        int incrementedYear = movieMaker.getCurrentYear();
        
        assertEquals(Calendar.getInstance().get(Calendar.YEAR)+1, incrementedYear);      
    }
    
    @Test
    public void randomMovieTitleNotNull(){
        Movie random = movieMaker.newRandom();
        
        assertNotNull(random.getTitle());
    }
    
    @Test
    public void randomMovieGenreNotNull(){
        Movie random = movieMaker.newRandom();
        
        assertNotNull(random.getGenre());
    }
    
    @Test
    public void randomMovieYearOver1950(){
        Movie random = movieMaker.newRandom();
        
        assertTrue(random.getYear() >= 1950);
    }
    
    @Test
    public void randomMovieRatingsGreaterThanZeroAndNotOver10(){
        Movie random = movieMaker.newRandom();
        
        assertTrue(random.getRatings() <= 10 && random.getRatings() > 0);
    }

}
