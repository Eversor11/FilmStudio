package filmstudio.movies;

import java.util.Calendar;
import java.util.Random;

public class MovieMaker {

    private int currentYear;
    private String[] genres = {"Action", "Comedy"};
    private TitleGenerator titleGenerator;
    private Random random;

    public MovieMaker() {
        this.currentYear = Calendar.getInstance().get(Calendar.YEAR);
        titleGenerator = new TitleGenerator();
        random = new Random();
    }
    
    public int getCurrentYear(){
        return this.currentYear;
    }

    public void incrementCurrentYear() {
        this.currentYear++;
    }

    public Movie newRandom() {

        int year = year();
        String genre = genre();
        String title = generateTitle(genre);
        double ratings = ratings();

        return new Movie(title, year, genre, ratings);
    }

    private String generateTitle(String genre) {
        return titleGenerator.generateTitle("src/filmstudio/movies/" + genre + "_adjectives.txt",
                                            "src/filmstudio/movies/" + genre + "_nouns.txt");
    }

    private int year() {
        return this.currentYear - random.nextInt(this.currentYear - 1949);
    }

    private String genre() {
        return genres[random.nextInt(genres.length)];
    }

    private double ratings() {

        double value = 0;

        int dice1 = random.nextInt(11);
        int dice2 = random.nextInt(10);

        if (dice1 == 10) {
            value = 10;
        } else if (dice1 == 0 && dice2 == 0) {
            value = 0.1;
        } else {
            value += dice1 + (double) dice2 / 10;
        }

        return value;
    }
}
