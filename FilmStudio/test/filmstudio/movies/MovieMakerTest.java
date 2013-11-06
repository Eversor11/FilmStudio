
package filmstudio.movies;

import filmstudio.utilities.FileReader;
import java.util.Calendar;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class MovieMakerTest {
    
    FileReader fileReader;
    MovieMaker movieMaker;
    Movie randomMovie;
    Random random;

    @Before
    public void setUp() throws Exception {
        this.fileReader = new FileReader();
        this.random = new Random(1);
        movieMaker = new MovieMaker(fileReader, random);
        randomMovie = movieMaker.newRandom();
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
    public void randomMovieTitleCorrectlyGenerated(){ 
        assertEquals("Hard Battle", randomMovie.getTitle());
    }
    
    @Test
    public void randomMovieGenreCorrectlyGenerated(){
        assertEquals("Action", randomMovie.getGenre());
    }
    
    @Test
    public void randomMovieYearCorrectlyGenerated(){
        assertEquals(1967, randomMovie.getYear());
    }
    
    @Test
    public void randomMovieRatingsCorrectlyGenerated(){
        assertEquals(2.4, randomMovie.getRatings(), 0);
    }

}
