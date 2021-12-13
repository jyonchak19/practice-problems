package main.java.ObjectOriented.OOReview;

public class Employee extends Person{
    private String employeeId;

    public Employee(int age, String name, String employeeId){
        super(age, name);
        this.employeeId = employeeId;
    }

//    public static String convertIdType(String employeeId) {
//
//    }
}
