package filmstudio.data;

import filmstudio.movies.Movie;
import filmstudio.persons.Person;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DatabaseTest {

    Database database;
    Movie movie;
    Person person;

    @Before
    public void setUp() {
        database = new Database();
        movie = new Movie("Bad Grandpa", 2013, "Comedy", 7.0);
        person = new Person("Male", "Arnold", "Donitsi", 42);
        movie.addToCastAndCrew("Director", person);
        person.addMovie(movie, "Director");
        database.addMovie(movie);
        database.addPerson(person);
    }

    @Test
    public void showAllMoviesCorrectly() {
        assertEquals("Bad Grandpa (2013) Comedy 7.0/10\n" +
                     "Director: Arnold Donitsi\n\n", database.showAllMovies());
    }

    @Test
    public void showAllPersonsCorrectly() {
        assertEquals("Arnold Donitsi\n" +
                     "Gender: Male\n" +
                     "Age: 42\n" +
                     "{Director=70}\n" +
                     "Movies involved in:\n" +
                     "Bad Grandpa (2013) - Director\n\n\n", 
                     database.showAllPersons());
    }

    @Test
    public void noNullMovies() {
        database.addMovie(null);
        assertEquals("Bad Grandpa (2013) Comedy 7.0/10\n" +
                     "Director: Arnold Donitsi\n\n", database.showAllMovies());
    }
    
    @Test
    public void noDuplicateMovies(){
        database.addMovie(new Movie("Bad Grandpa", 2013, "Comedy", 7.0));
        assertEquals("Bad Grandpa (2013) Comedy 7.0/10\n" +
                     "Director: Arnold Donitsi\n\n", database.showAllMovies());
    }

    @Test
    public void noNullPersons() {
        database.addPerson(null);
        assertEquals("Arnold Donitsi\n" +
                     "Gender: Male\n" +
                     "Age: 42\n" +
                     "{Director=70}\n" +
                     "Movies involved in:\n" +
                     "Bad Grandpa (2013) - Director\n\n\n", 
                     database.showAllPersons());
    }
    
    @Test
    public void noDuplicatePersons(){
        database.addPerson(new Person("Male", "Arnold", "Donitsi", 42));
        assertEquals("Arnold Donitsi\n" +
                     "Gender: Male\n" +
                     "Age: 42\n" +
                     "{Director=70}\n" +
                     "Movies involved in:\n" + 
                     "Bad Grandpa (2013) - Director\n\n\n", 
                     database.showAllPersons());
    }
}
