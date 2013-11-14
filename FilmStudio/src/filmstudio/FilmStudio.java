package filmstudio;

import filmstudio.data.Database;
import filmstudio.data.HistoryGenerator;
import filmstudio.movies.MovieMaker;
import filmstudio.persons.PersonCreator;
import filmstudio.utilities.FileReader;
import java.util.Random;

public class FilmStudio {

    public static void main(String[] args) {

        Random random = new Random();
        FileReader fileReader = new FileReader();
        Database database = new Database();
        MovieMaker movieMaker;
        PersonCreator personCreator;
        HistoryGenerator historyGenerator;
        
        try{
            movieMaker = new MovieMaker(fileReader, random);
            personCreator = new PersonCreator(fileReader, random);
            historyGenerator = new HistoryGenerator(database, movieMaker, personCreator, fileReader);
            historyGenerator.generateHistory(10);
        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println(database.showAllMovies());
        System.out.println(database.showAllPersons());
    }
}
