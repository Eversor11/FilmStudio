package filmstudio;

import filmstudio.movies.Movie;
import filmstudio.movies.MovieMaker;
import filmstudio.persons.Person;
import filmstudio.persons.PersonCreator;
import filmstudio.utilities.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FilmStudio {

    public static void main(String[] args) {

        Random random = new Random();
        FileReader fileReader = new FileReader();

        List<Movie> movies = new ArrayList<Movie>();
        List<Person> persons = new ArrayList<Person>();

        try {
            MovieMaker movieMaker = new MovieMaker(fileReader, random);

            for (int i = 0; i < 9; i++) {
                Movie randomMovie = movieMaker.newRandom();
                movies.add(randomMovie);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        movies.add(new Movie("Bad Grandpa", 2013, "Comedy", 7.0));

        for (Movie movie : movies) {
            System.out.println(movie);
        }
        
        System.out.println("");
        
        try {
            PersonCreator personCreator = new PersonCreator(fileReader, random);

            for (int i = 0; i < 9; i++) {
                Person randomPerson = personCreator.newRandom();
                persons.add(randomPerson);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        persons.add(new Person("Male", "Arnold", "Donitsi", 42));

        for (Person person : persons) {
            System.out.println(person);
            System.out.println("");
        }

    }
}
