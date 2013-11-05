
package filmstudio.movies;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class MovieMakerTest {
    
    MovieMaker movieMaker;
    Movie random;

    @Before
    public void setUp() {
        movieMaker = new MovieMaker();
        random = movieMaker.newRandom();
    }
    
    @Test
    public void currentYearIsCorrect(){
        assertEquals(Calendar.getInstance().get(Calendar.YEAR), movieMaker.getCurrentYear());
    }
    
    @Test
    public void currentYearIncrementedCorrectly(){
        movieMaker.incrementCurrentYear();
        
        assertEquals(Calendar.getInstance().get(Calendar.YEAR)+1, movieMaker.getCurrentYear());      
    }
    
    @Test
    public void randomMovieTitleNotNull(){ 
        assertNotNull(random.getTitle());
    }
    
    @Test
    public void randomMovieGenreNotNull(){
        assertNotNull(random.getGenre());
    }
    
    @Test
    public void randomMovieYearOver1950(){
        assertTrue(random.getYear() >= 1950);
    }
    
    @Test
    public void randomMovieRatingsGreaterThanZeroAndNotOver10(){
        assertTrue(random.getRatings() <= 10 && random.getRatings() > 0);
    }

}
