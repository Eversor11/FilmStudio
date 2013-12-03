package filmstudio.movies;

import filmstudio.utilities.FileReader;
import java.io.File;
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
        this.genres = fileReader.readFile("resources"+File.separator+
                                          "movies"+File.separator+
                                          "genres.txt");
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

        int year = generateYear();
        String genre = generateGenre();
        String title = generateTitle(genre.toLowerCase());
        double ratings = generateRatings();

        return new Movie(title, year, genre, ratings);
    }

    /**
     * Metodi, joka parametrina annetun genren perusteella generoi elokuvalle
     * nimen. Palauttaa parametrina annettavien genrepohjaisten tiedostopolkujen 
     * perusteella titleGeneratorin luoman nimen elokuvalle.
     * 
     * @param genre Elokuvan genre
     * @return Palauttaa generoidun nimen elokuvalle
     * @throws Exception Mahdollinen poikkeus, joka heitetään tiedoston luvun
     *                   epäonnistuttua
     */
    private String generateTitle(String genre) throws Exception {
        return titleGenerator.generateTitle("resources"+File.separator +
                                            "movies"+File.separator + 
                                            genre + "_adjectives.txt", 
                                            "resources"+File.separator +
                                            "movies"+File.separator + 
                                            genre + "_nouns.txt");
    }

    /**
     * Metodi, joka generoi elokuvan julkaisuvuoden. Palauttaa nykyisen vuoden
     * ja randomilla arvotun luvun (0-63 vuodella 2013) erotuksen.
     * 
     * @return Palauttaa elokuvan julkaisuvuoden
     */
    private int generateYear() {
        return this.currentYear - random.nextInt(this.currentYear - 1949);
    }

    /**
     * Metodi, joka generoi elokuvan genren. Palauttaa genre-listalta
     * arvotun genren.
     * 
     * @return Palauttaa elokuvan genren
     */
    private String generateGenre() {
        return genres.get(random.nextInt(genres.size()));
    }

    /**
     * Metodi, joka generoi elokuvan arvosanojen keskiarvon. Heittää kahta
     * noppaa, toisen kokonaisluvulle 0:n ja 10:n väliltä ja toisen desimaalille
     * 0:n ja 9:n väliltä. Maksimiarvo 10 ja minimi 0.1
     * 
     * @return Palauttaa elokuvan arvosanojen keskiarvon
     */
    private double generateRatings() {

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
