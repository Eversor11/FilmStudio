
package filmstudio.movies;

import filmstudio.persons.Person;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class MovieTest {

    Movie movie;
    Person person;
    
    @Before
    public void setUp() {
        movie = new Movie("Bad Grandpa", 2013, "Comedy", 7.0);
        person = new Person("Male","Arnold", "Donitsi", 42);
        movie.addToCastAndCrew("Director", person);
    }
    
    @Test
    public void toStringDisplaysCorrectly(){
        assertEquals("Bad Grandpa (2013) Comedy 7.0/10\nDirector: Arnold Donitsi\n", movie.toString());
    }
    
    @Test
    public void noDuplicatePositionsForMovies(){
        movie.addToCastAndCrew("Director", new Person("Male","No","Bonus",12));
        assertEquals("Director: Arnold Donitsi\n", movie.showAllCastAndCrew());
    }


}
