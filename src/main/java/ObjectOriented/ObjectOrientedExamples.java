//package main.java.ObjectOriented;
//
//import java.util.*;
//
//public class ObjectOrientedExamples {
//
////    gameCode () {
////        DeckOfCards deck = new DeckOfCards(); // by default will create a 52 card deck
////        deck.draw();
////        deck.draw(5);
////        deck.shuffle();
////
////    }
//
//    public class DeckOfCards{
//        private ArrayList<Card> cards;
//
//        // default constructor
//        public DeckOfCards(){
//            //Create the deck in an arraylist
//            //52 cards, 4 suits, values 1-13
//        }
//        // potentially have other constructors...
//    }
//
//    public enum Suit {
//        Club (0), Diamond (1), Heart (2), Spade(3);
//        private int value;
//        private Suit(int v) {value = v;}
//    }
//
//    public class Card{
//        int value;
//
//    }
////    public static void main(String[] args) {
////        Person bob = new Person(35, "Bob");
////        bob
////    }
//    // a class for a shape - any shape that has width and height
//    public class Shape {
//        private double height;
//        private double width;
//
//        public void setValues(double height, double width) {
//            this.height = height;
//            this.width = width;
//        }
//        public double getHeight() {
//            return height;
//        }
//        public double getWidth() {
//            return width;
//        }
////        main () {
////            Shape shape;
////            Rectangle rect = new Rectangle();
////            shape = rect;
////            shape.setValues(78,5);
////
////            System.out.println("Area of rect: "+ rect.getArea());
////
////            Triangle tri = new Triangle();
////            shape = tri; // upcasting, which happens by default as well
////            shape.setValues(34,3);
////            System.out.println("Area of triangle: " + tri.getArea());
////            Shape myShape;
////            Rectangle myRect;
////            myRect = (Rectangle)myShape; // downcasting
////        }
//
//    }
//
//    public class Rectangle extends Shape {
//       public double getArea() {
//           return getHeight() * getWidth();
//       }
//    }
//
//    public class Triangle extends Shape {
//        public double getArea() {
//            return (getHeight() * getWidth()) / 2;
//        }
//    }
//    // information HIDING.
//    // access modifiers: private, public, protected
////    public class AuthLoginController {
////        private config;
////        private loginInfo;
////        public AuthLoginController(loginInfo) {
////            this.grinder = new Grinder();
////        }
////        public Login login(selection) {
////            switch(userType) {
////                case Admin:
////                    return brewEspresso()
////            }
////        }
////        private adminLogin()
////
////    }
//
//}
//
//// employee login system: base class employee: name, employeeId, age
////  shiftmanager
//public class Employee {
//    public String name;
//    private int employeeId;
//    private int age;
//
//    public Employee(String name, int employeeId, int age){
//        this.name = name;
//        this.employeeId = employeeId;
//        this.age = age;
//    }
//
//    public int getAge(){
//        return age;
//    }
//
//}
//public class ShiftManager extends Employee {
//    private Employee[] subordinates;
//
//    public ShiftManager(String name, int employeeId, int age, Employee[] subordinates){
//        super(name, employeeId, age);
//        this.subordinates = subordinates;
//    }
//}
//// bob, jon, joe, jim - supervisor
//Employee bob = new Employee("bob", 1, 94);
//Employee jon = new Employee("jon", 2, 12);
//Employee joe = new Employee("joe", 3, 45);
//Employee[] jimSubordinates = {bob, jon, joe};
//ShiftManager jim = new ShiftManager("jim", 10, 3, jimSubordinates);
//
//public class EmployeeRegistration {
//    Employee[] registeredEmployees;
//    public static String registrationId = "AGETB4236S";
//    public EmployeeRegistration(){
//
//    }
//
//    public static void updateRegistrationId(String newId){
//        registrationId = newId;
//    }
//}
//
//// this is some main ...
//EmployeeRegistration.registrationId;
//EmployeeRegistration.updateRegistrationId("AJETKL54235");
//
//public class Car {
//    static double convertMpgKpl(double mpg) {
//
//    }
//    void setMileage(double mpg) {
//
//    }
//}