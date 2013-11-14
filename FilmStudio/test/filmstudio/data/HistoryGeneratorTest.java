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
        historyGenerator = new HistoryGenerator(database, movieMaker, personCreator, fileReader);
        historyGenerator.generateHistory(2);
    }
    
    @Test
    public void moviesGeneratedCorrectly(){
        assertEquals("Hard Battle (1967) Action 2.4/10\nDirector: Elwood Higbee\n"
                     +"Screenwriter: Adrienne Yacavone\nLead Actor: Raye Robertson\n"
                     +"Supporting Actor: Daniele Sweeney\n\n"
                     +"Odd Boys (1976) Comedy 10.0/10\nDirector: Thelma Sheperd\n"
                     +"Screenwriter: Amal Leadingham\nLead Actor: Dawn Levin\n"
                     +"Supporting Actor: Ronald Orff\n\n", database.showAllMovies());
    }
    
    @Test
    public void personsGeneratedCorrectly(){
        assertEquals("Elwood Higbee\nGender: Male\nAge: 91\n{Director=24}\n\n"
                     +"Adrienne Yacavone\nGender: Female\nAge: 100\n{Screenwriter=24}\n\n"
                     +"Raye Robertson\nGender: Female\nAge: 83\n{Lead Actor=24}\n\n"
                     +"Daniele Sweeney\nGender: Female\nAge: 70\n{Supporting Actor=24}\n\n"
                     +"Thelma Sheperd\nGender: Female\nAge: 54\n{Director=100}\n\n"
                     +"Amal Leadingham\nGender: Female\nAge: 61\n{Screenwriter=100}\n\n"
                     +"Dawn Levin\nGender: Female\nAge: 49\n{Lead Actor=100}\n\n"
                     +"Ronald Orff\nGender: Male\nAge: 89\n{Supporting Actor=100}\n\n", database.showAllPersons());
    }
}
