package filmstudio.persons;

import filmstudio.movies.Movie;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {

    Person person;
    Person person2;
    Movie movie;

    @Before
    public void setUp() {
        person = new Person("Male", "Arnold", "Donitsi", 42);
        person2 = new Person("Male", "Arnold", "Donitsi", 42);
        movie = new Movie("Bad Grandpa", 2013, "Comedy", 7.0);
        movie.addToCastAndCrew("Director", person);
        person.addMovie(movie);
    }

    @Test
    public void allInfoDisplaysCorrectly() {
        assertEquals("Arnold Donitsi\nGender: Male\nAge: 42\n{Director=70}\nMovies involved in:\n"
                     + "Bad Grandpa (2013) - Director\n", person.allInfo());
    }

    @Test
    public void fameAddedCorrectlyToExistingPosition() {
        person.addFameToPosition("Director", 10);
        assertEquals("Arnold Donitsi\nGender: Male\nAge: 42\n{Director=80}\nMovies involved in:\n"
                     + "Bad Grandpa (2013) - Director\n", person.allInfo());
    }

    @Test
    public void positionalFameNeverBelowZero() {
        person.addFameToPosition("Director", 10);
        person.addFameToPosition("Director", -200);
        assertEquals("Arnold Donitsi\nGender: Male\nAge: 42\n{Director=0}\nMovies involved in:\n"
                     + "Bad Grandpa (2013) - Director\n", person.allInfo());
    }
    
    @Test
    public void noPositionsDisplayedCorrectly(){
        assertEquals("",person2.getPosition());
    }

    @Test
    public void getPositionWithMostFame() {
        person.addFameToPosition("Screenwriter", 10);
        person.addFameToPosition("Lead Actor", 100);
        assertEquals("Lead Actor", person.getPosition());
    }
    
    @Test
    public void noDuplicateMovies(){
        person.addMovie(movie);
        assertEquals("Arnold Donitsi\nGender: Male\nAge: 42\n{Director=70}\nMovies involved in:\n"
                     + "Bad Grandpa (2013) - Director\n", person.allInfo());
    }
    
    @Test
    public void personComparedCorrectly1(){
        assertEquals(0, person.compareTo(new Person("Male", "Arnold", "Donitsi", 42)));
    }
    
    @Test
    public void personComparedCorrectly2(){
        assertTrue(person.compareTo(new Person("Male", "Aarnold", "Donitsi", 42))>0);
    }
    
    @Test
    public void personComparedCorrectly3(){
        assertTrue(person.compareTo(new Person("Male", "Karnold", "Donitsi", 42))<0);
    }
    
    @Test
    public void personComparedCorrectly4(){
        assertTrue(person.compareTo(new Person("Male", "Arnold", "Bonitsi", 42))>0);
    }
    
    @Test
    public void personComparedCorrectly5(){
        assertTrue(person.compareTo(new Person("Male", "Arnold", "Tonitsi", 42))<0);
    }
}
