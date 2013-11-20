package filmstudio.data;

import filmstudio.movies.Movie;
import filmstudio.persons.Person;
import java.util.ArrayList;
import java.util.List;

/**
 * Database-luokka, joka pitää sisällään tiedot peliin luoduista elokuvista ja
 * henkilöistä.
 *
 * @author Eversor
 */
public class Database {

    private List<Movie> movies;
    private List<Person> persons;

    /**
     * Konstruktori, joka luo uudet arraylistat ja asettaa ne niiden private
     * muuttujiin.
     * 
     */
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
    
    /**
     * Metodi, joka lisää annetun elokuvan niille tarkoitetulle listalle.
     * Tarkastaa ensin että elokuva ei ole null ja että sitä ei löydy jo
     * listalta.
     * 
     * @param movie Listalle lisättävä elokuva
     */
    public void addMovie(Movie movie) {
        if(movie != null && !movies.contains(movie)){
            movies.add(movie);
        }       
    }
    
    /**
     * Metodi, joka lisää annetun henkilön niille tarkoitetulle listalle.
     * Tarkastaa ensin että henkilö ei ole null ja että sitä ei löydy jo
     * listalta.
     * 
     * @param person Listalle lisättävä henkilö
     */
    public void addPerson(Person person) {
        if(person != null && !persons.contains(person)){
            persons.add(person);
        }       
    }
    
    /**
     * Metodi, joka palauttaa merkkijonona kaikki listan sisältämien elokuvien
     * tiedot.
     * 
     * @return Palauttaa merkkijonona kaikki listan sisältämien elokuvien tiedot 
     */
    public String showAllMovies() {
        String allMovies = "";
        for (Movie movie : movies) {
            allMovies += movie.allInfo()+"\n";
        }
        return allMovies;
    }
    
    /**
     * Metodi, joka palauttaa merkkijonona kaikki listan sisältämien henkilöiden
     * tiedot.
     * 
     * @return Palauttaa merkkijonona kaikki listan sisältämien henkilöiden 
     *         tiedot 
     */
    public String showAllPersons() {
        String allPersons = "";
        for (Person person : persons) {
            allPersons += person.allInfo()+"\n\n";
        }
        return allPersons;
    }
}
