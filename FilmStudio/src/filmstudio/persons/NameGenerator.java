package filmstudio.persons;

import java.util.List;
import java.util.Random;

/**
 * NameGenerator-luokka, joka generoi annetulta listalta nimiä
 * 
 * @author Eversor
 */

public class NameGenerator {
    
    /**
     * Satunnaislukugeneraattori satunnaislukujen arpomiseen
     */

    private Random random;

    public NameGenerator(Random random) {
        this.random = random;
    }
    
    /**
     * Metodi generoi annetulta listalta nimen, jonka frekvenssi
     * on annettujen kvartiilien mukainen eli saadaan populaation
     * frekvenssin mukaisesti generoitua nimiä
     * 
     * @param names Lista nimiä, joista valitaan generoitava nimi
     * @param Q1 Viimeinen alkio, joka kuuluu ensimmäiseen kvartiiliin
     *           (Alkioiden järjestysluku alkaa yhdestä)
     * @param Q2 Viimeinen alkio, joka kuuluu toiseen kvartiiliin
     * @param Q3 Viimeinen alkio, joka kuuluu kolmanteen kvartiiliin
     * 
     * @return Populaation frekvenssin mukaan generoitu nimi
     */

    public String generateName(List<String> names, int Q1, int Q2, int Q3) {

        int dice1 = random.nextInt(100) + 1;
        int dice2;

        if (dice1 > 75) {
            dice2 = random.nextInt(names.size() - Q3) + Q3;
        } else if (dice1 > 50) {
            dice2 = random.nextInt(Q3 - Q2) + Q2;
        } else if (dice1 > 25) {
            dice2 = random.nextInt(Q2 - Q1) + Q1;
        } else {
            dice2 = random.nextInt(Q1);
        }
        return names.get(dice2);
    }
}
