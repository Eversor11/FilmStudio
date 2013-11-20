package filmstudio.data;

import filmstudio.movies.Movie;
import filmstudio.persons.Person;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DataSearchTest {
    
    Database database;
    DataSearch dataSearch;
    Movie movie;
    Movie movie2;
    Person person;
    Person person2;
    List<Person> foundPerson;
    List<Movie> foundMovie;
    
    @Before
    public void setUp() {
        database = new Database();
        person = new Person("Male", "Arnold", "Donitsi", 42);
        person2 = new Person("Male", "John", "Smith", 60);
        movie = new Movie("Bad Grandpa", 2013, "Comedy", 7.0);
        movie2 = new Movie("Y2K", 1999, "Action", 10);
        database.addPerson(person);
        database.addPerson(person2);
        database.addMovie(movie);
        database.addMovie(movie2);
        dataSearch = new DataSearch(database);
        foundPerson = new ArrayList<Person>();
        foundPerson.add(person);
        foundMovie = new ArrayList<Movie>();
        foundMovie.add(movie);
    }
    
    @Test
    public void personFoundCorrectly1(){
        assertEquals(foundPerson, dataSearch.searchPersonByName("Arnold Donitsi"));
    }
    
    @Test
    public void personFoundCorrectly2(){
        assertEquals(foundPerson, dataSearch.searchPersonByName("      ar   "));
    }
    
    @Test
    public void personFoundCorrectly3(){
        assertEquals(foundPerson, dataSearch.searchPersonByName("NIT"));
    }
    
    @Test
    public void personFoundCorrectly4(){
        assertEquals(foundPerson, dataSearch.searchPersonByName("  old d"  ));
    }
    
    @Test
    public void personFoundCorrectly5(){
        foundPerson.add(person2);
        assertEquals(foundPerson, dataSearch.searchPersonByName(""));
    }
    
    @Test
    public void movieFoundCorrectly1(){
        assertEquals(foundMovie, dataSearch.searchMovieByName("Bad Grandpa"));
    }
    
    @Test
    public void movieFoundCorrectly2(){
        assertEquals(foundMovie, dataSearch.searchMovieByName("    ad   "));
    }
    
    @Test
    public void movieFoundCorrectly3(){
        assertEquals(foundMovie, dataSearch.searchMovieByName("AND"));
    }
    
    @Test
    public void movieFoundCorrectly4(){
        assertEquals(foundMovie, dataSearch.searchMovieByName("   d gr "));
    }
    
    @Test
    public void movieFoundCorrectly5(){
        foundMovie.add(movie2);
        assertEquals(foundMovie, dataSearch.searchMovieByName(""));
    }
}
