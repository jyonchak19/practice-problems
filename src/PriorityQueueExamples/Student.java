package PriorityQueueExamples;

import java.util.Scanner;

public class Student implements Comparable<Student> {

    // a queue of students
    // two types of students, students who've entered the queue and those who have
    // been "served" - exited the queue

    // a student will have a unique ID
    // a name
    // a GPA (double)

    // queue CRITERIA:
    // 1. student with HIGHEST(!) GPA is served first
    // 2. same GPA students will be served by their name (alphabetical order)
    // 3. same GPA, same name, served by order of ID (natural order of integers)

    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    // returns 0, -1, 1
    public int compareTo(Student secondStudent) {
        // currStudent.getGpa() > secondStudent.getGpa() -> returns 1, reverse returns -1

        int gpaCompare = Double.compare(secondStudent.getGpa(), this.getGpa());
        if(gpaCompare != 0)
            return gpaCompare;
        else {
            int nameCompare = this.getName().compareTo(secondStudent.getName());
            if(nameCompare != 0)
                return nameCompare;
            else {
                return Integer.compare(this.getId(), secondStudent.getId());
            }
        }
    }
}



