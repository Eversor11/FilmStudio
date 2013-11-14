package filmstudio.data;

import filmstudio.movies.Movie;
import filmstudio.movies.MovieMaker;
import filmstudio.persons.Person;
import filmstudio.persons.PersonCreator;
import filmstudio.utilities.FileReader;
import java.util.ArrayList;
import java.util.List;

public class HistoryGenerator {

    private Database database;
    private MovieMaker movieMaker;
    private PersonCreator personCreator;
    private List<String> castAndCrewPositions;

    public HistoryGenerator(Database database, MovieMaker movieMaker,
            PersonCreator personCreator, FileReader fileReader) throws Exception {
        this.database = database;
        this.movieMaker = movieMaker;
        this.personCreator = personCreator;
        this.castAndCrewPositions = fileReader.readFile("src/filmstudio/data/castAndCrewPositions.txt");
    }

    public void generateHistory(int movieCount) throws Exception {
        for (int i = 0; i < movieCount; i++) {
            Movie movie = movieMaker.newRandom();
            List<Person> castAndCrew = createCastAndCrew(movie, castAndCrewPositions.size());
            for(int j = 0; j < castAndCrewPositions.size(); j++){
                movie.addToCastAndCrew(castAndCrewPositions.get(j), castAndCrew.get(j));
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
