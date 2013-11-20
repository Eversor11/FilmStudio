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
    private List<Movie> movies;

    public Person(String gender, String firstName, String surname, int age) {
        this.gender = gender;
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
        positions = new HashMap<String, Integer>();
        movies = new ArrayList<Movie>();
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

    public void addFameToPosition(String position, int fame) {
        addPosition(position);
        if (positions.get(position) + fame < 0) {
            positions.put(position, 0);
        } else {
            positions.put(position, positions.get(position) + fame);
        }
    }

    public void addMovie(Movie movie) {
        if (movies != null && !movies.contains(movie)) {
            movies.add(movie);
        }
    }

    public List<Movie> getMovies() {
        return movies;
    }
    
    public int getMoviesSize(){
        return movies.size();
    }

    public String showAllMovies() {
        String allMovies = "Movies involved in:\n";
        for (Movie movie : movies) {
            allMovies += movie.getTitle() + " (" + movie.getYear() + ") - "
                    + movie.getPositionOfPerson(new Person(getGender(), getFirstName(), getSurname(), getAge())) + "\n";
        }
        return allMovies;
    }
    
    public String allInfo(){
        return this.firstName + " " + this.surname + "\nGender: " + this.gender
                + "\nAge: " + this.age + "\n" + positions + "\n" + showAllMovies();
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.surname;
    }
    
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
