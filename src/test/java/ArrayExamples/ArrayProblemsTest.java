package test.java.ArrayExamples;

import main.java.ArrayExamples.ArrayProblems;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class ArrayProblemsTest {
    @Test
    public void simpleFizzBuzzTest(){
        ArrayList<String> expectedResult1 = new ArrayList<>(List.of("1","2","Fizz"));
        ArrayList<String> expectedResult2 = new ArrayList<>(List.of("1","2","Fizz","4","Buzz"));
        ArrayList<String> expectedResult3 = new ArrayList<>(List.of(
                "1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"));
        Assert.assertEquals(expectedResult1,ArrayProblems.simpleFizzBuzz(3));
        Assert.assertEquals(expectedResult2,ArrayProblems.simpleFizzBuzz(5));
        Assert.assertEquals(expectedResult3,ArrayProblems.simpleFizzBuzz(15));
    }

    @Test
    public void lessSimpleFizzBuzzTest(){
        ArrayList<String> expectedResult1 = new ArrayList<>(List.of("Fizz", "4", "Buzz"));
        ArrayList<String> expectedResult2 = new ArrayList<>(List.of("Buzz"
    }
}
