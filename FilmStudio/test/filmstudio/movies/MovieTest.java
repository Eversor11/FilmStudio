package filmstudio.movies;

import filmstudio.persons.Person;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MovieTest {

    Movie movie;
    Movie movie2;
    Person person;

    @Before
    public void setUp() {
        movie = new Movie("Bad Grandpa", 2013, "Comedy", 7.0);
        movie2 = new Movie("Bad Grandma", 2013, "Comedy", 9.0);
        person = new Person("Male", "Arnold", "Donitsi", 42);
        movie.addToCastAndCrew("Director", person);     
    }

    @Test
    public void allInfoDisplaysCorrectly() {
        assertEquals("Bad Grandpa (2013) Comedy 7.0/10\nDirector: " +
                     "Arnold Donitsi\n", movie.allInfo());
    }
    
    @Test
    public void showAllCastAndCrewCorrectlyWhenEmpty() {
        assertEquals("", movie2.showAllCastAndCrew());
    }

    @Test
    public void noDuplicatePositionsForMovies() {
        movie.addToCastAndCrew("Director", 
                               new Person("Male", "No", "Bonus", 12));
        assertEquals("Director: Arnold Donitsi\n", movie.showAllCastAndCrew());
    }

    @Test
    public void getPositionOfPersonCorrectly1() {
        assertEquals("Director", movie.getPositionOfPerson(person));
    }
    
    @Test
    public void getPositionOfPersonCorrectly2() {
        assertEquals("",movie.getPositionOfPerson(
                     new Person("Male", "Karnold", "Donitsi", 42)));
    }

    @Test
    public void movieComparedCorrectly1() {
        assertEquals(0, movie.compareTo(
                     new Movie("Bad Grandpa", 2011, "Action", 8.0)));
    }

    @Test
    public void movieComparedCorrectly2() {
        assertTrue(movie.compareTo(
                   new Movie("CAD Grandpa", 2013, "Comedy", 7.0)) < 0);
    }

    @Test
    public void movieComparedCorrectly3() {
        assertTrue(movie.compareTo(
                   new Movie("Ad Grandpa", 2013, "Comedy", 7.0)) > 0);
    }
}
