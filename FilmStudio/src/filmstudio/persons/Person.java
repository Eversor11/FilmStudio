
package filmstudio.persons;


public class Person {
    
    private String gender;
    private String firstName;
    private String surname;
    private int age;
    
    public Person(String gender, String firstName, String surname, int age){
        this.gender = gender;
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
    }
    
    public String getGender(){
        return this.gender;
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    public String getSurname(){
        return this.surname;
    }
    
    public int getAge(){
        return this.age;
    }
    
    @Override
    public String toString(){
        return ""+this.firstName+" "+this.surname+"\nGender: "+this.gender+"\nAge: "+this.age;
    }

}
