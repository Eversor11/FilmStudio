
package filmstudio.movies;


public class Movie {
    
    private String title;
    private int year;
    private String genre;
    private double ratings;

    public Movie(String title, int year, String genre, double ratings) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.ratings = ratings;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public String getGenre() {
        return this.genre;
    }

    public double getRatings() {
        return this.ratings;
    }

    @Override
    public String toString() {
        return this.title + " (" + this.year + ") " + this.genre + " " + this.ratings + "/10";
    }

}
