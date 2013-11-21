package filmstudio.persons;

import filmstudio.movies.Movie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Person-luokka, joka toteuttaa Comparable-rajapinnan ja josta luodut ilmentymät
 * pitävät sisällään kyseiseen henkilöön liittyvät tiedot
 *
 * @author Eversor
 */
public class Person implements Comparable<Person> {

    private String gender;
    private String firstName;
    private String surname;
    private int age;
    private Map<String, Integer> positions;
    private Map<Movie, String> movies;

    /**
     * Konstruktori, jolle annetaan parametreinä henkilön sukupuoli, etunimi,
     * sukunimi ja ikä, jotka asetetaan niiden private muuttujiin. Tämän jälkeen
     * luodaan uusi hashmap sisältämään henkilön käyttämät toiminimet ja
     * niiden nimekkyys sekä uusi lista, joka pitää sisällään elokuvat joiden 
     * tekemiseen henkilö on osallistunut. Lopuksi nämä talletetaan niiden
     * private muuttujiin.
     * 
     * @param gender Henkilön sukupuoli
     * @param firstName Henkilön etunimi
     * @param surname Henkilön sukunimi
     * @param age Henkilön ikä
     */
    public Person(String gender, String firstName, String surname, int age) {
        this.gender = gender;
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
        positions = new HashMap<String, Integer>();
        movies = new HashMap<Movie, String>();
    }

    public String getGender() {
        return this.gender;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getSurname() {
        return this.surname;
    }

    public int getAge() {
        return this.age;
    }
  
    /**
     * Metodi, joka kasvattaa henkilön ikää yhdellä.
     * 
     */
    public void growOlder(){
        this.age++;
    }

    /**
     * Metodi, joka palauttaa merkkijonona henkilön toiminimen, jolla on eniten
     * nimekkyyttä.
     * 
     * @return Palauttaa merkkijonona henkilön toiminimen, jolla on eniten
     *         nimekkyyttä.
     */
    public String getPosition() {
        if(positions == null){
            return "";
        }
        return positionWithMostFame();    
    }
    
    private String positionWithMostFame(){
        int mostFame = -1;
        String positionWithMostFame = "";
        for (String position : positions.keySet()) {
            if (positions.get(position) > mostFame) {
                mostFame = positions.get(position);
                positionWithMostFame = position;
            }
        }
        return positionWithMostFame;
    }

    private void addPosition(String position) {
        if (!positions.containsKey(position)) {
            positions.put(position, 0);
        }
    }

    /**
     * Metodi, joka lisää annetun parametrin verran nimekkyyttä parametrina
     * annetulle toiminimelle. Lisää aluksi toiminimen henkilön tietoihin, jos 
     * sitä ei siellä vielä ole. Tämän jälkeen tarkastaa tuleeko lopulliseksi
     * nimekkyydeksi negatiivinen luku, jos tulee niin asettaa nimekkyyden
     * arvoksi 0. Jos tulee positiivinen luku, niin asettaa nimekkyyden arvoksi
     * alkuperäisen nimekkyyden ja parametrina annetun nimekkyyden arvon summan.
     * 
     * @param position Toiminimi, jonka nimekkyyttä muokataan
     * @param fame Nimekkyyden määrä, joka toiminimeen lisätään (voi siis olla
     *             negatiivinen, jos henkilön toiminta ajan mittaan "unohtuu")
     */
    public void addFameToPosition(String position, int fame) {
        addPosition(position);
        if (positions.get(position) + fame < 0) {
            positions.put(position, 0);
        } else {
            positions.put(position, positions.get(position) + fame);
        }
    }

    /**
     * Metodi, joka lisää parametrina annetun elokuvan ja siinä käytetyn
     * toiminimen henkilön tietoihin. Tarkastaa ensin, että elokuva ei ole null
     * eikä sitä ole jo valmiiksi tiedoissa.
     * 
     * @param movie Elokuva, joka lisätään henkilön tietoihin
     * @param position Toiminimi, joka lisätään elokuvan tietoihin
     */
    public void addMovie(Movie movie, String position) {
        if (movies != null && !movies.keySet().contains(movie)) {
            movies.put(movie, position);
        }
    }

    public List<Movie> getMovies() {
        return new ArrayList<Movie>(movies.keySet());
    }
    
    public int getMoviesSize(){
        return movies.size();
    }

    /**
     * Metodi, joka palauttaa merkkijonona kaikki elokuvat joiden tekemisessä
     * henkilö on ollut mukana sekä toiminimen, jolla toiminut elokuvaa
     * tehdessä.
     * 
     * @return Palauttaa merkkijonona kaikki elokuvat joiden tekemisessä
     *         henkilö on ollut mukana sekä toiminimen, jolla toiminut elokuvaa
     *         tehdessä
     */
    public String showAllMovies() {
        String allMovies = "Movies involved in:\n";
        for (Movie movie : movies.keySet()) {
            allMovies += movie.getTitle() + " (" + movie.getYear() + ") - "
                       + movies.get(movie) + "\n";
        }
        return allMovies;
    }
    
    /**
     * Metodi, joka palauttaa merkkijonona kaiken oleellisen tiedon henkilöstä.
     * 
     * @return Palauttaa merkkijonona kaiken oleellisen tiedon henkilöstä.
     */
    public String allInfo(){
        return this.firstName + " " + this.surname + "\nGender: " + this.gender
                + "\nAge: " + this.age + "\n" + positions + "\n" + showAllMovies();
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.surname;
    }
    
    /**
     * Metodi, joka vertailee kahta henkilöä ensin sukunimen perusteella ja
     * tarvittaessa myös etunimen perusteella. Aakkosissa ensin oleva henkilö
     * saa positiivisen arvon.
     * 
     * @param person Henkilö, keneen verrataan
     * @return Palauttaa kokonaislukuna vertailun tuloksen.
     */
    @Override
    public int compareTo(Person person) {

        int nameComparison = this.surname.compareTo(person.getSurname());
        
        if(nameComparison == 0){
           nameComparison = this.firstName.compareTo(person.getFirstName());
        }
        return nameComparison;

    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (getClass() != object.getClass()) {
            return false;
        }

        Person person = (Person) object;

        if (this.gender == null || !this.gender.equals(person.getGender())) {
            return false;
        }

        if (this.firstName == null || !this.firstName.equals(person.getFirstName())) {
            return false;
        }

        if (this.surname == null || !this.surname.equals(person.getSurname())) {
            return false;
        }

        if (this.age != person.getAge()) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {

        if (this.gender == null || this.firstName == null || this.surname == null) {
            return this.age;
        }

        return this.age + this.gender.hashCode() + this.firstName.hashCode() + this.surname.hashCode();
    }
}
