package filmstudio.data;

import filmstudio.movies.Movie;
import filmstudio.persons.Person;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private List<Movie> movies;
    private List<Person> persons;

    public Database() {
        movies = new ArrayList<Movie>();
        persons = new ArrayList<Person>();
    }

    public List<Movie> getMovieList() {
        return movies;
    }

    public List<Person> getPersonList() {
        return persons;
    }

    public int getMovieSize() {
        return movies.size();
    }

    public int getPersonSize() {
        return persons.size();
    }
    
    public void addMovie(Movie movie) {
        if(movie != null){
            movies.add(movie);
        }       
    }
    
    public void addPerson(Person person) {
        if(person != null){
            persons.add(person);
        }       
    }
    
    public String showAllMovies() {
        String allMovies = "";
        for (Movie movie : movies) {
            allMovies += movie+"\n";
        }
        return allMovies;
    }
    
    public String showAllPersons() {
        String allPersons = "";
        for (Person person : persons) {
            allPersons += person+"\n\n";
        }
        return allPersons;
    }
}
