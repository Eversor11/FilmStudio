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
        database.addMovie(movie);
        database.addPerson(person);
    }

    @Test
    public void showAllMoviesCorrectly() {
        assertEquals("Bad Grandpa (2013) Comedy 7.0/10\nDirector: Arnold Donitsi\n\n", database.showAllMovies());
    }

    @Test
    public void showAllPersonsCorrectly() {
        assertEquals("Arnold Donitsi\nGender: Male\nAge: 42\n{Director=70}\n\n", database.showAllPersons());
    }

    @Test
    public void noNullMovies() {
        database.addMovie(null);
        assertEquals("Bad Grandpa (2013) Comedy 7.0/10\nDirector: Arnold Donitsi\n\n", database.showAllMovies());
    }

    @Test
    public void noNullPersons() {
        database.addPerson(null);
        assertEquals("Arnold Donitsi\nGender: Male\nAge: 42\n{Director=70}\n\n", database.showAllPersons());
    }
}
