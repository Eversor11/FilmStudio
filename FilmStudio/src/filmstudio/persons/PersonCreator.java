package filmstudio.persons;

import filmstudio.utilities.FileReader;
import java.util.List;
import java.util.Random;

/**
 * PersonCreator-luokka, jonka avulla voidaan generoida henkilöitä
 *
 * @author Eversor
 */
public class PersonCreator {

    private Random random;
    private NameGenerator nameGenerator;
    private List<String> maleNames;
    private List<String> femaleNames;
    private List<String> surnames;

    /**
     * Konstruktori, jolle annetaan parametreina FileReader- ja Random-luokan
     * ilmentymät. Ensin asetetaan Random-luokan ilmentymä sen private
     * muuttujaan. Sitten luodaan uusi ilmentymä NameGenerator-luokasta, jolle
     * annetaan parametrina saatu Random-luokan ilmentymä, ja asetetaan se sen
     * private muuttujaan. Lopuksi luetaan tiedostoista miesten ja naisten
     * nimet sekä sukunimet, joista henkilön nimi generoidaan ja asetetaan ne
     * niiden private listoihin.
     * 
     * @param fileReader FileReader-luokan ilmentymä, jonka avulla voidaan lukea
     *                   tiedostojen sisältöä 
     * @param random     Random-luokan ilmentymä satunnaislukujen arpomiseen
     * @throws Exception Mahdollinen poikkeus, joka heitetään tiedoston luvun
     *                   epäonnistuttua
     */
    public PersonCreator(FileReader fileReader, Random random) throws Exception {
        this.random = random;
        nameGenerator = new NameGenerator(random);
        maleNames = fileReader.readFile("src/resources/persons/maleNames.txt");
        femaleNames = fileReader.readFile("src/resources/persons/femaleNames.txt");
        surnames = fileReader.readFile("src/resources/persons/surnames.txt");
    }

    /**
     * Metodi, jolla generoidaan uusi henkilö. Ensin generoidaan henkilön
     * sukupuoli, jonka avulla sitten generoidaan henkilön etunimi. Seuraavaksi
     * generoidaan henkilön sukunimi ja lopuksi ikä, johon lisätään parametrina
     * annettu lisäikä. Elokuvahistoriaa luotaessa ideana on siis generoida 
     * henkilö elokuvan julkaisuhetkelle, johon lisätään parametrina annettu 
     * nykyisen vuoden (pelin aloitusvuoden) ja elokuvan julkaisuvuoden erotus.
     * 
     * @param addedAge Generoitavaan ikään lisättävä ikä, joka on nykyisen 
     *                 vuoden ja elokuvan julkaisuvuoden erotus elokuvahistoriaa
     *                 generoitaessa
     * @return         Palauttaa generoiden henkilön
     * @throws Exception Mahdollinen poikkeus, joka heitetään tiedoston luvun
     *                   epäonnistuttua nimien luomisessa
     */
    public Person newRandom(int addedAge) throws Exception {

        String gender = gender();
        String firstName = firstName(gender);
        String surname = surname();
        int age = age() + addedAge;

        return new Person(gender, firstName, surname, age);
    }

    /**
     * Metodi, joka generoi henkilölle sukupuolen. Todennäköisyydet sukupuolelle
     * ovat yhtäsuuret. Palauttaa lopuksi generoidun sukupuolen.
     * 
     * @return Palauttaa generoidun sukupuolen
     */
    private String gender() {
        if (random.nextInt(2) > 0) {
            return "Male";
        } else {
            return "Female";
        }
    }

    /**
     * Metodi, joka parametrina annetun sukupuolen perusteella generoi
     * henkilölle etunimen. Aluksi tarkastaa kumpaa sukupuolta on ja tämän
     * jälkeen nameGeneratorin generateName-metodia kutsutaan parametreilla,
     * jotka ovat lista sukupuoleen pohjautuvista nimistä sekä nimilistan
     * esiintymistiheyksien kvartiilit. Lopuksi palauttaa generoidun etunimen.
     * 
     * @param gender Henkilön sukupuoli
     * @return Palauttaa henkilön etunimen
     * @throws Exception Mahdollinen poikkeus joka heitetään, jos tiedoston
     *                   luku epäonnistuu etunimen generoimisessa
     */
    private String firstName(String gender) throws Exception {

        if (gender.equals("Male")) {
            return nameGenerator.generateName(maleNames, 12, 60, 233);
        } else {
            return nameGenerator.generateName(femaleNames, 38, 139, 524);
        }
    }

    /**
     * Metodi, joka generoi henkilölle sukunimen. Aluksi kutsuu nameGeneratorin 
     * generateName-metodia parametreilla, jotka ovat lista sukunimistä sekä 
     * sukunimilistan esiintymistiheyksien kvartiilit. Lopuksi palauttaa 
     * generoidun sukunimen.
     * 
     * @return Palauttaa henkilön sukunimen
     * @throws Exception Mahdollinen poikkeus joka heitetään, jos tiedoston
     *                   luku epäonnistuu sukunimen generoimisessa
     */
    private String surname() throws Exception {
        return nameGenerator.generateName(surnames, 197, 1712, 14585);
    }

    /**
     * Metodi, joka generoi henkilön iän. Arpoo luvun 0:n ja 48:n väliltä ja
     * lisää tähän 12. Ikähaarukka on siis 12-60. Palauttaa lopuksi generoidun
     * iän.
     * 
     * @return Palauttaa henkilön iän
     */
    private int age() {
        return random.nextInt(49) + 12;
    }
}
