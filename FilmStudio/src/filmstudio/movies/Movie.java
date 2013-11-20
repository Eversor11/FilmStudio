package filmstudio.movies;

import filmstudio.persons.Person;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Movie-luokka, joka toteuttaa Comparable-rajapinnan ja josta luodut ilmentymät
 * pitävät sisällään kyseiseen elokuvaan liittyvät tiedot
 *
 * @author Eversor
 */
public class Movie implements Comparable<Movie> {

    private String title;
    private int year;
    private String genre;
    private double ratings;
    private Map<String, Person> castAndCrew;

    /**
     * Konstruktori, jolle annetaan parametreinä elokuvan nimi, julkaisuvuosi, 
     * genre sekä sen saamien arvosanojen keskiarvo. Nämä asetetaan niiden 
     * private muuttujiin.
     *
     * @param title Elokuvan nimi
     * @param year Elokuvan tekovuosi
     * @param genre Elokuvan genre
     * @param ratings Elokuvan saamien arvosanojen keskiarvo
     */
    public Movie(String title, int year, String genre, double ratings) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.ratings = ratings;
        castAndCrew = new LinkedHashMap<String, Person>();
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

    /**
     * Metodi, joka lisää parametrina annetun henkilön elokuvan toimihenkilöksi
     * parametrina annetulla toiminimellä. Ensin tarkastaa ettei kyseisellä
     * toiminimellä löydy elokuvan tiedoista henkilöä, jonka jälkeen lisää
     * henkilön toiminimellä tietoihin. Lopuksi lisää nimekkyyttä henkilön
     * toiminimelle algoritmin mukaisesti.
     *
     * @param position Toiminimi, jolla henkilö lisätään tietohin
     * @param person Henkilö, joka lisätään elokuvan toimihenkilöksi
     */
    public void addToCastAndCrew(String position, Person person) {
        if (!castAndCrew.containsKey(position)) {
            castAndCrew.put(position, person);
            person.addFameToPosition(position, (int) (getRatings() * 10));
        }
    }

    /**
     * Metodi, joka palauttaa merkkijonona kaikki elokuvaan kuuluvat henkilöt
     * sekä niiden toiminimet elokuvan teossa.
     *
     * @return Palauttaa merkkijonona elokuvan toimihenkilöt ja toiminimet
     */
    public String showAllCastAndCrew() {
        String allCastAndCrew = "";
        for (String position : castAndCrew.keySet()) {
            allCastAndCrew += position + ": " + castAndCrew.get(position).getFirstName()
                    + " " + castAndCrew.get(position).getSurname() + "\n";
        }
        return allCastAndCrew;
    }

    /**
     * Metodi, joka palauttaa parametrina annetun henkilön toiminimen, jos
     * henkilö on ollut tekemässä elokuvaa. Tarkastaa ensin, että henkilö ei ole
     * null, jonka jälkeen tarkastaa löytyykö henkilöä elokuvan tiedoista. Jos
     * ei löydy, palauttaa tyhjän merkkijonon.
     *
     * @param person Henkilö, jonka toiminimi halutaan tietää
     * @return Palauttaa merkkijonona toiminimen, jolla henkilö on työskennellyt
     *         elokuvaa tehdessä
     */
    public String getPositionOfPerson(Person person) {
        if (person != null) {
            for (Entry<String, Person> entry : castAndCrew.entrySet()) {
                if (person.equals(entry.getValue())) {
                    return entry.getKey();
                }
            }
        }
        return "";
    }

    /**
     * Metodi, joka palauttaa merkkijonona kaiken oleellisen tiedon kyseisestä
     * elokuvasta.
     *
     * @return Palauttaa merkkijonona kaiken oleellisen tiedon kyseisestä
     * elokuvasta
     */
    public String allInfo() {
        return this.title + " (" + this.year + ") " + this.genre + " " + this.ratings + "/10\n" + showAllCastAndCrew();
    }

    @Override
    public String toString() {
        return this.title;
    }

    @Override
    public int compareTo(Movie movie) {
        return this.title.compareTo(movie.getTitle());
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (getClass() != object.getClass()) {
            return false;
        }

        Movie movie = (Movie) object;

        if (this.title == null || !this.title.equals(movie.getTitle())) {
            return false;
        }

        if (this.genre == null || !this.genre.equals(movie.getGenre())) {
            return false;
        }

        if (this.year != movie.getYear()) {
            return false;
        }

        if (this.ratings != movie.getRatings()) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {

        if (this.title == null || this.genre == null) {
            return this.year + (int) (this.ratings * 10);
        }

        return this.year + (int) (this.ratings * 10) + this.title.hashCode() + this.genre.hashCode();
    }
}
