package filmstudio.data;

import filmstudio.movies.MovieMaker;
import filmstudio.persons.PersonCreator;
import filmstudio.utilities.FileReader;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HistoryGeneratorTest {

    Random random;
    FileReader fileReader;
    Database database;
    MovieMaker movieMaker;
    PersonCreator personCreator;
    HistoryGenerator historyGenerator;

    @Before
    public void setUp() throws Exception {
        random = new Random(1);
        fileReader = new FileReader();
        database = new Database();
        movieMaker = new MovieMaker(fileReader, random);
        personCreator = new PersonCreator(fileReader, random);
        historyGenerator = new HistoryGenerator(database, movieMaker, 
                                                personCreator, fileReader);
        historyGenerator.generateHistory(2);
    }
    
    @Test
    public void moviesGeneratedCorrectly(){
        assertEquals("Hard Battle (1967) Action 2.4/10\n" +
                     "Director: Elwood Higbee\n" +
                     "Screenwriter: Adrienne Yacavone\n" +
                     "Lead Actor: Raye Robertson\n" +
                     "Supporting Actor: Daniele Sweeney\n\n" +
                     "Odd Boys (1976) Comedy 10.0/10\n" +
                     "Director: Thelma Sheperd\n" +
                     "Screenwriter: Amal Leadingham\n" +
                     "Lead Actor: Dawn Levin\n" +
                     "Supporting Actor: Ronald Orff\n\n", 
                     database.showAllMovies());
    }
    
    @Test
    public void personsGeneratedCorrectly(){
        assertEquals("Elwood Higbee\n" +
                     "Gender: Male\n" +
                     "Age: 91\n" +
                     "{Director=24}\n" +
                     "Movies involved in:\n" +
                     "Hard Battle (1967) - Director\n\n\n" +
                     "Adrienne Yacavone\n" +
                     "Gender: Female\n" +
                     "Age: 100\n" +
                     "{Screenwriter=24}\n" +
                     "Movies involved in:\n" +
                     "Hard Battle (1967) - Screenwriter\n\n\n" +
                     "Raye Robertson\n" +
                     "Gender: Female\n" +
                     "Age: 83\n" +
                     "{Lead Actor=24}\n" +
                     "Movies involved in:\n" +
                     "Hard Battle (1967) - Lead Actor\n\n\n" +
                     "Daniele Sweeney\n" +
                     "Gender: Female\n" +
                     "Age: 70\n" +
                     "{Supporting Actor=24}\n" +
                     "Movies involved in:\n" +
                     "Hard Battle (1967) - Supporting Actor\n\n\n" +
                     "Thelma Sheperd\n" +
                     "Gender: Female\n" +
                     "Age: 54\n" +
                     "{Director=100}\n" +
                     "Movies involved in:\n" +
                     "Odd Boys (1976) - Director\n\n\n" +
                     "Amal Leadingham\n" +
                     "Gender: Female\n" +
                     "Age: 61\n"+
                     "{Screenwriter=100}\n" +
                     "Movies involved in:\n" +
                     "Odd Boys (1976) - Screenwriter\n\n\n" +
                     "Dawn Levin\n" +
                     "Gender: Female\n" +
                     "Age: 49\n" +
                     "{Lead Actor=100}\n" +
                     "Movies involved in:\n" +
                     "Odd Boys (1976) - Lead Actor\n\n\n" +
                     "Ronald Orff\n" +
                     "Gender: Male\n" +
                     "Age: 89\n" +
                     "{Supporting Actor=100}\n" +
                     "Movies involved in:\n" +
                     "Odd Boys (1976) - Supporting Actor\n\n\n", 
                     database.showAllPersons());
    }
}
