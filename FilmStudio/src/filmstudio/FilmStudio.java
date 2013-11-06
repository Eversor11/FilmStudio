package filmstudio;

import filmstudio.movies.Movie;
import filmstudio.movies.MovieMaker;
import filmstudio.utilities.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FilmStudio {

    public static void main(String[] args) {

        Random random = new Random();
        FileReader fileReader = new FileReader();

        List<Movie> movies = new ArrayList<Movie>();

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

    }
}
