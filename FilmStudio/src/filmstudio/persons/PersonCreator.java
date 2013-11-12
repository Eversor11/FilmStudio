package filmstudio.persons;

import filmstudio.utilities.FileReader;
import java.util.List;
import java.util.Random;

public class PersonCreator {

    private Random random;
    private NameGenerator nameGenerator;
    private List<String> maleNames;
    private List<String> femaleNames;
    private List<String> surnames;

    public PersonCreator(FileReader fileReader, Random random) throws Exception {
        this.random = random;
        nameGenerator = new NameGenerator(random);
        maleNames = fileReader.readFile("src/filmstudio/persons/maleNames.txt");
        femaleNames = fileReader.readFile("src/filmstudio/persons/femaleNames.txt");
        surnames = fileReader.readFile("src/filmstudio/persons/surnames.txt");
    }

    public Person newRandom() throws Exception {

        String gender = gender();
        String firstName = firstName(gender);
        String surname = surname();
        int age = age();

        return new Person(gender, firstName, surname, age);
    }

    private String gender() {
        if (random.nextInt(2) > 0) {
            return "Male";
        } else {
            return "Female";
        }
    }

    private String firstName(String gender) throws Exception {

        if (gender.equals("Male")) {
            return nameGenerator.generateName(maleNames, 12, 60, 233);
        } else {
            return nameGenerator.generateName(femaleNames, 38, 139, 524);
        }
    }

    private String surname() throws Exception {
        return nameGenerator.generateName(surnames, 197, 1712, 14585);
    }

    private int age() {
        return random.nextInt(49) + 12;
    }
}
