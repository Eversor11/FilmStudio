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
    
    /**
     * Lista merkkijonoja, jonne luetaan tiedostosta kaikki mahdolliset
     * elokuvien toiminimet.
     * 
     */
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
     * Toimihenkilöille lisätään generoitu elokuva ja siinä käytetty toiminimi
     * henkilötietoihin ja lopuksi elokuva lisätään databaseen.
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
                castAndCrew.get(j).addMovie(movie,castAndCrewPositions.get(j));
            }
            database.addMovie(movie);
        }
    }

    /**
     * Metodi, jolla luodaan parametrina annettuun elokuvaan parametrina
     * annettu määrä toimihenkilöitä. For-loopin alussa generoidaan uusi
     * henkilö, jolle annetaan parametrina nykyisen vuoden ja elokuvan
     * julkaisuvuoden erotus. Tämän jälkeen listaan lisätään luotu henkilö ja
     * samalla lisätään hänet myös databaseen. Lopuksi palautetaan lista
     * elokuvaan luoduista toimihenkilöistä.
     * 
     * @param movie Elokuva, johon luodaan toimihenkilöitä
     * @param positionCount Toiminimien lukumäärä
     * @return Palauttaa listan elokuvaan luotuja toimihenkilöitä
     * @throws Exception Mahdollinen poikkeus, joka heitetään henkilöiden 
     *                   luomisen yhteydessä
     */
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
