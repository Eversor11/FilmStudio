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
        person.addMovie(movie, "Director");
    }

    @Test
    public void allInfoDisplaysCorrectly() {
        assertEquals("Arnold Donitsi\nGender: Male\nAge: 42\n{Director=70}\n" +
                     "Movies involved in:\nBad Grandpa (2013) - Director\n", 
                     person.allInfo());
    }

    @Test
    public void growsOlderCorrectly() {
        person.growOlder();
        assertEquals(43, person.getAge());
    }
    
    @Test
    public void fameAddedCorrectlyToExistingPosition() {
        person.addFameToPosition("Director", 10);
        assertEquals("Arnold Donitsi\nGender: Male\nAge: 42\n{Director=80}\n" +
                     "Movies involved in:\nBad Grandpa (2013) - Director\n", 
                     person.allInfo());
    }

    @Test
    public void positionalFameNeverBelowZero() {
        person.addFameToPosition("Director", 10);
        person.addFameToPosition("Director", -200);
        assertEquals("Arnold Donitsi\nGender: Male\nAge: 42\n{Director=0}\n" +
                     "Movies involved in:\nBad Grandpa (2013) - Director\n", 
                     person.allInfo());
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
        person.addMovie(movie, "Lead Actor");
        assertEquals("Arnold Donitsi\nGender: Male\nAge: 42\n{Director=70}\n" +
                     "Movies involved in:\nBad Grandpa (2013) - Director\n", 
                     person.allInfo());
    }
    
    @Test
    public void personComparedCorrectly1(){
        assertEquals(0, person.compareTo(
                     new Person("Male", "Arnold", "Donitsi", 42)));
    }
    
    @Test
    public void personComparedCorrectly2(){
        assertTrue(person.compareTo(
                   new Person("Male", "Aarnold", "Donitsi", 42))>0);
    }
    
    @Test
    public void personComparedCorrectly3(){
        assertTrue(person.compareTo(
                   new Person("Male", "Karnold", "Donitsi", 42))<0);
    }
    
    @Test
    public void personComparedCorrectly4(){
        assertTrue(person.compareTo(
                   new Person("Male", "Arnold", "Bonitsi", 42))>0);
    }
    
    @Test
    public void personComparedCorrectly5(){
        assertTrue(person.compareTo(
                   new Person("Male", "Arnold", "Tonitsi", 42))<0);
    }
}
