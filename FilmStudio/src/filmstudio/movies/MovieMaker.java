package filmstudio.movies;

import filmstudio.utilities.FileReader;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * MovieMaker-luokka, jonka avulla voidaan generoida elokuvia
 *
 * @author Eversor
 */
public class MovieMaker {

    private int currentYear;
    private List<String> genres;
    private TitleGenerator titleGenerator;
    private Random random;

    /**
     * Konstruktori, jolle annetaan parametreinä FileReader- ja Random-luokkien
     * ilmentymät. Ensin nykyisen vuoden private muuttujaan asetetaan Calendar-
     * luokasta kutsuttu vuosiluku, jonka jälkeen Random-luokan ilmentymä 
     * asetetaan sen private muuttujaan. Genreille tarkoitettuun listaan luetaan
     * FileReader-luokan ilmentymän avulla tiedostosta elokuvien mahdolliset
     * genret. Lopuksi luodaan uusi TitleGenerator-luokan ilmentymä, jolle
     * annetaan parametreina FileReader- ja Random-luokkien ilmentymät ja tämä
     * asetetaan sen private muuttujaan.
     * 
     * @param fileReader FileReader-luokan ilmentymä, jonka avulla voidaan lukea
     *                   tiedostojen sisältöä
     * @param random     Random-luokan ilmentymä satunnaislukujen arpomiseen
     * @throws Exception Mahdollinen poikkeus, joka heitetään tiedoston luvun
     *                   epäonnistuttua
     */
    public MovieMaker(FileReader fileReader, Random random) throws Exception {
        this.currentYear = Calendar.getInstance().get(Calendar.YEAR);
        this.random = random;
        this.genres = fileReader.readFile("src/resources/movies/genres.txt");
        titleGenerator = new TitleGenerator(fileReader, random);
    }

    public int getCurrentYear() {
        return this.currentYear;
    }

    /**
     * Metodi, joka kasvattaa nykyistä vuotta yhdellä.
     * 
     */
    public void incrementCurrentYear() {
        this.currentYear++;
    }

    /**
     * Metodi, joka generoi uuden elokuvan. Ensin generoidaan elokuvan julkaisu-
     * vuosi, jonka jälkeen generoidaan elokuvan genre. Seuraavaksi generoidaan
     * elokuvan nimi genren perusteella, jonka jälkeen generoidaan elokuvan
     * arvosanojen keskiarvo. Lopuksi palautetaan kyseisillä tiedoilla luotu
     * elokuvan ilmentymä.
     * 
     * @return Palautetaan elokuvan ilmentymä generoiduilla tiedoilla
     * @throws Exception Mahdollinen poikkeus, joka heitetään tiedoston luvun
     *                   epäonnistuttua elokuvan nimen generoinnissa
     */
    public Movie newRandom() throws Exception {

        int year = year();
        String genre = genre();
        String title = generateTitle(genre);
        double ratings = ratings();

        return new Movie(title, year, genre, ratings);
    }

    private String generateTitle(String genre) throws Exception {
        return titleGenerator.generateTitle("src/resources/movies/" + genre + "_adjectives.txt",
                "src/resources/movies/" + genre + "_nouns.txt");
    }

    private int year() {
        return this.currentYear - random.nextInt(this.currentYear - 1949);
    }

    private String genre() {
        return genres.get(random.nextInt(genres.size()));
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
