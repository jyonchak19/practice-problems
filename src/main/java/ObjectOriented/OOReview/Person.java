package main.java.ObjectOriented.OOReview;
import java.util.ArrayList;


public class Person {
    private int age;
    private String name;
    protected String catchphrase;

    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void setCatchphrase(String catchphrase){
        this.catchphrase = catchphrase;
    }

    public static void main(String[] args) {
        Person bob = new Person(34, "Bob");
        System.out.println(bob);
        // Prints: Person@84e38990
        Person allie = new Person(26, "Allie");
        Employee jon = new Employee(34, "john", "kofju89w234ujf");
        ArrayList<Person> people = new ArrayList<>();

        for(Person person: people){
            // employees, managers, students, ...
        }

    }
}
