package filmstudio.movies;

import filmstudio.persons.Person;
import java.util.LinkedHashMap;
import java.util.Map;

public class Movie {

    private String title;
    private int year;
    private String genre;
    private double ratings;
    private Map<String, Person> castAndCrew;

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
    
    public void addToCastAndCrew(String position, Person person){
        if(!castAndCrew.containsKey(position)){
            castAndCrew.put(position, person);
            person.addFameToPosition(position, (int)(getRatings()*10));
        }
    }
    
    public String showAllCastAndCrew(){
        String allCastAndCrew = "";
        for(String position : castAndCrew.keySet()){
            allCastAndCrew += position+": "+castAndCrew.get(position).getFirstName()+" "+
                                            castAndCrew.get(position).getSurname()+"\n";
        }
        return allCastAndCrew;
    }

    @Override
    public String toString() {
        return this.title + " (" + this.year + ") " + this.genre + " " + this.ratings + "/10\n"+showAllCastAndCrew();
    }
}
