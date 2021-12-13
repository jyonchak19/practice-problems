package main.java.ComparatorExamples;

import java.util.Comparator;

// will compare strings based on their length
public class CustomStringComparator implements Comparator<String>{
    public int compare(String firstString, String secondString) {
        return firstString.length() - secondString.length();
    }


}

