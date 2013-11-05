
package filmstudio;

import filmstudio.movies.Movie;
import filmstudio.movies.MovieMaker;
import java.util.ArrayList;
import java.util.List;

public class FilmStudio {

    public static void main(String[] args) {
        
        MovieMaker movieMaker = new MovieMaker();
        
        List<Movie> movies = new ArrayList<Movie>();
        for(int i = 0; i<9; i++){
            Movie random = movieMaker.newRandom();
            movies.add(random);
        }

        movies.add(new Movie("Bad Grandpa", 2013, "Comedy", 7.0));
        
        for(Movie movie : movies){
            System.out.println(movie);
        }
        
    }
}
