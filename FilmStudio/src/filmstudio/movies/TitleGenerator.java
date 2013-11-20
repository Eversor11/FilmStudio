package filmstudio.movies;

import filmstudio.utilities.FileReader;
import java.util.List;
import java.util.Random;

/**
 * TitleGenerator-luokka, jonka avulla voidaan generoida elokuvien nimiä
 * annetuista tiedostopoluista
 *
 * @author Eversor
 */
public class TitleGenerator {

    private Random random;
    private FileReader fileReader;

    /**
     * Konstruktori, jolle annetaan parametreinä FileReader- ja Random-luokkien
     * ilmentymät, jotka asetetaan niiden private muuttujiin.
     * 
     * @param fileReader FileReader-luokan ilmentymä, jonka avulla voidaan lukea
     *                   tiedostojen sisältöä
     * @param random     Random-luokan ilmentymä satunnaislukujen arpomiseen
     */
    public TitleGenerator(FileReader fileReader, Random random) {
        this.fileReader = fileReader;
        this.random = random;
    }

    /**
     * Metodi, joka generoi elokuvan nimen annettujen tiedostopolkujen
     * perusteella. Aluksi luetaan annetuista tiedostopoluista sanat joiden
     * avulla generoidaan, jonka jälkeen arvotaan tyyli millä elokuvan nimi
     * generoituu. Lopuksi palautetaan merkkijonona generoitu elokuvan nimi.
     * 
     * @param adjectivesPath Tiedostopolku merkkijonona adjektiiveille
     * @param nounsPath Tiedostopolku merkkijonona substantiiveille
     * @return Palauttaa merkkijonona generoidun nimen elokuvalle
     * @throws Exception Mahdollinen poikkeus, joka heitetään tiedoston luvun
     *                   epäonnistuttua
     */
    public String generateTitle(String adjectivesPath, String nounsPath) throws Exception {
        String title = "";

        List<String> adjectiveList = fileReader.readFile(adjectivesPath);
        List<String> nounList = fileReader.readFile(nounsPath);

        if (random.nextInt(9) > 0) {
            title = adjectiveNoun(adjectiveList, nounList);
        } else {
            title = articleNoun(nounList);
        }

        return title;
    }

    private String adjectiveNoun(List<String> adjectiveList, List<String> nounList) {
        String title = "";

        title += adjectiveList.get(random.nextInt(adjectiveList.size()));
        title += " ";
        title += nounList.get(random.nextInt(nounList.size()));

        return title;
    }

    private String articleNoun(List<String> nounList) {
        String title = "";

        title += "The ";
        title += nounList.get(random.nextInt(nounList.size()));

        return title;
    }
}
