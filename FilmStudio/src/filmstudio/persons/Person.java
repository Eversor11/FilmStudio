package filmstudio.persons;

import java.util.HashMap;
import java.util.Map;

public class Person {

    private String gender;
    private String firstName;
    private String surname;
    private int age;
    private Map<String, Integer> positions;

    public Person(String gender, String firstName, String surname, int age) {
        this.gender = gender;
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
        positions = new HashMap<String, Integer>();
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
        int mostFame = -1;
        String positionWithMostFame = "";
        for(String position : positions.keySet()){
            if(positions.get(position) > mostFame){
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

    @Override
    public String toString() {
        return "" + this.firstName + " " + this.surname + "\nGender: " + this.gender + "\nAge: " + this.age + "\n" + positions;
    }
}
