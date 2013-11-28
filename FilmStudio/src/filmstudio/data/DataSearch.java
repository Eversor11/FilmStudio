package filmstudio.data;

import filmstudio.movies.Movie;
import filmstudio.persons.Person;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * DataSearch-luokka, jonka avulla voidaan etsiä Database-ilmentymästä tietoa
 * merkkijonohaulla.
 *
 * @author Eversor
 */
public class DataSearch {

    private Database database;

    /**
     * Konstruktori, jolle annetaan parametrina Database-luokan ilmentymä.
     * Ilmentymä asetetaan sen private muuttujaan.
     * 
     * @param database Database-luokan ilmentymä, joka pitää sisällään tiedot
     *                 pelissä olevista henkilöistä ja elokuvista
     */
    public DataSearch(Database database) {
        this.database = database;
    }

    /**
     * Metodi, joka kutsuttaessa palauttaa listan elokuvista, jotka
     * hakualgoritmin mukaisesti on löydetty annetulla merkkijono-parametrilla
     * 
     * @param name Merkkijono jolla etsitään
     * @return Palauttaa listan elokuvista, jotka on löydetty
     */
    public List<Movie> searchMovieByName(String name) {

        if (name == null || name.trim().equals("")) {
            Collections.sort(database.getMovieList());
            return database.getMovieList();
        }

        return searchedAndSortedMovieList(name.trim().toLowerCase());
    }

    /**
     * Metodi, joka kutsuttaessa palauttaa listan henkilöistä, jotka
     * hakualgoritmin mukaisesti on löydetty annetulla merkkijono-parametrilla
     * 
     * @param name Merkkijono jolla etsitään
     * @return Palauttaa listan henkilöistä, jotka on löydetty
     */
    public List<Person> searchPersonByName(String name) {

        if (name == null || name.trim().equals("")) {
            Collections.sort(database.getPersonList());
            return database.getPersonList();
        }

        return searchedAndSortedPersonList(name.trim().toLowerCase());
    }

    /**
     * Metodi, joka kutsuttaessa palauttaa listan elokuvista, jotka ovat
     * löydetty parametrina annetulla merkkijonolla. For-loopissa käydään
     * databasen elokuvat läpi, ja jos pienaakkosiksi muutettu elokuvan nimi
     * sisältää merkkijonon, niin kyseinen elokuva lisätään palautettavaan
     * listaan. Loopin jälkeen lista sortataan nimen mukaisesti. Lopuksi 
     * palautetaan lista elokuvista, jotka on löydetty.
     * 
     * @param name Merkkijono jolla etsitään
     * @return Palauttaa listan elokuvista, jotka on löydetty
     */
    private List<Movie> searchedAndSortedMovieList(String name) {
        List<Movie> found = new ArrayList<Movie>();

        for (Movie movie : database.getMovieList()) {
            if (movie.getTitle().toLowerCase().contains(name)) {
                found.add(movie);
            }
        }
        Collections.sort(found);

        return found;
    }

    /**
     * Metodi, joka kutsuttaessa palauttaa listan henkilöistä, jotka ovat
     * löydetty parametrina annetulla merkkijonolla. For-loopissa käydään
     * databasen henkilöt läpi, ja jos pienaakkosiksi muutettu henkilön koko
     * nimi sisältää merkkijonon, niin kyseinen henkilö lisätään palautettavaan
     * listaan. Loopin jälkeen lista sortataan nimen mukaisesti. Lopuksi 
     * palautetaan lista henkilöistä, jotka on löydetty.
     * 
     * @param name Merkkijono jolla etsitään
     * @return Palauttaa listan henkilöistä, jotka on löydetty
     */
    private List<Person> searchedAndSortedPersonList(String name) {
        List<Person> found = new ArrayList<Person>();

        for (Person person : database.getPersonList()) {
            String fullName = person.getFirstName() + " " + person.getSurname();
            if (fullName.toLowerCase().contains(name)) {
                found.add(person);
            }
        }
        Collections.sort(found);

        return found;
    }
}
