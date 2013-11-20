package filmstudio.data;

import filmstudio.movies.Movie;
import filmstudio.movies.MovieMaker;
import filmstudio.persons.Person;
import filmstudio.persons.PersonCreator;
import filmstudio.utilities.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * HistoryGenerator-luokka, jonka avulla voidaan luoda elokuva- ja henkilö-
 * historia uuden pelin käynnistysvaiheessa.
 *
 * @author Eversor
 */
public class HistoryGenerator {

    private Database database;
    private MovieMaker movieMaker;
    private PersonCreator personCreator;
    private List<String> castAndCrewPositions;

    /**
     * Konstruktori, jolle annetaan parametreina Database-, MovieMaker-,
     * PersonCreator- ja FileReader-luokkien ilmentymät. Kaikki muut ilmentymät
     * paitsi fileReader asetetaan niiden private muuttujiin. fileReader lukee
     * tiedostosta listan henkilöiden mahdollisista toiminimistä elokuvissa ja 
     * asettaa sen private muuttujaan.
     * 
     * @param database Database-luokan ilmentymä, joka pitää sisällään tiedot
     *                 pelissä olevista henkilöistä ja elokuvista
     * @param movieMaker MovieMaker-luokan ilmentymä, jonka avulla voidaan luoda
     *                   uusia elokuvia
     * @param personCreator PersonCreator-luokan ilmentymä, jonka avulla voidaan
     *                      luoda uusia henkilöitä
     * @param fileReader FileReader-luokan ilmentymä, jonka avulla voidaan lukea
     *                   tiedostojen sisältöä
     * @throws Exception Mahdollinen poikkeus, joka heitetään tiedoston luvun
     *                   epäonnistuttua
     */
    public HistoryGenerator(Database database, MovieMaker movieMaker,
            PersonCreator personCreator, FileReader fileReader) throws Exception {
        this.database = database;
        this.movieMaker = movieMaker;
        this.personCreator = personCreator;
        this.castAndCrewPositions = fileReader.readFile("src/resources/data/castAndCrewPositions.txt");
    }

    /**
     * Metodi, jolla luodaan elokuva- ja henkilöhistoria parametrina annetun
     * elokuvien lukumäärän perusteella. For-loopin alussa generoidaan uusi
     * elokuva. Tämän jälkeen generoidaan listalle henkilöt, jotka ovat
     * tehneet elokuvaa, jonka jälkeen ne asetetaan elokuvan toimihenkilöiksi.
     * Toimihenkilöille lisätään generoitu elokuva henkilötietoihin ja lopuksi
     * elokuva lisätään databaseen.
     * 
     * @param movieCount Elokuvien lukumäärä joka generoidaan
     * @throws Exception Mahdollinen poikkeus, joka heitetään elokuvien tai
     *                   henkilöiden luomisen yhteydessä
     */
    public void generateHistory(int movieCount) throws Exception {
        for (int i = 0; i < movieCount; i++) {
            Movie movie = movieMaker.newRandom();
            List<Person> castAndCrew = createCastAndCrew(movie, castAndCrewPositions.size());
            for(int j = 0; j < castAndCrewPositions.size(); j++){
                movie.addToCastAndCrew(castAndCrewPositions.get(j), castAndCrew.get(j));
                castAndCrew.get(j).addMovie(movie);
            }
            database.addMovie(movie);
        }
    }

    private List<Person> createCastAndCrew(Movie movie, int positionCount) throws Exception {
        List<Person> castAndCrew = new ArrayList<Person>();
        for (int i = 0; i < positionCount; i++) {
            Person person = personCreator.newRandom(movieMaker.getCurrentYear() - movie.getYear());
            castAndCrew.add(person);
            database.addPerson(person);
        }
        return castAndCrew;
    }
}
