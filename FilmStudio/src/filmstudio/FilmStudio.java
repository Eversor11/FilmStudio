package filmstudio;

import filmstudio.data.Database;
import filmstudio.data.HistoryGenerator;
import filmstudio.gui.SearchUI;
import filmstudio.movies.MovieMaker;
import filmstudio.persons.PersonCreator;
import filmstudio.utilities.FileReader;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * FilmStudio-luokka, joka luo peliin tarvittavat ilmentymät luokista ja
 * käyttöliittymän sekä generoi elokuvahistorian.
 *
 * @author Eversor
 */
public class FilmStudio {

    public static void main(String[] args) {

        Random random = new Random();
        FileReader fileReader = new FileReader();
        Database database = new Database();
        MovieMaker movieMaker;
        PersonCreator personCreator;
        HistoryGenerator historyGenerator;
        
        SearchUI searchUI = new SearchUI(database);
        searchUI.setLocationRelativeTo(null);
        searchUI.setVisible(true);
        
        try{
            movieMaker = new MovieMaker(fileReader, random);
            personCreator = new PersonCreator(fileReader, random);
            historyGenerator = new HistoryGenerator(database, movieMaker, 
                                                    personCreator, fileReader);
            historyGenerator.generateHistory(10);
        } catch(Exception e){
            JOptionPane.showMessageDialog(searchUI, "An error has occurred:\n"
                    +e.getMessage()+"\n\nRestart the program for safe usage as "
                    + "some features may not work.", "Error", 
                    JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: "+e.getMessage()); // testejä varten
        }
        
        
    }
}
