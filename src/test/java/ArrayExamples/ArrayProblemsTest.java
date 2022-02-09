package test.java.ArrayExamples;

import main.java.ArrayExamples.ArrayProblems;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class ArrayProblemsTest {
    @Test
    public void simpleFizzBuzzTest() {
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
        ArrayList<String> expectedResult1 = new ArrayList<>(List.of("Fizz","4","Buzz"));
        ArrayList<String> expectedResult2 = new ArrayList<>(List.of("Buzz", "Fizz","7","8",
                "Fizz","Buzz","11","Fizz","13","14","FizzBuzz"));
        ArrayList<String> expectedResult3 = new ArrayList<>(List.of("Fizz","Buzz","11","Fizz"));
        Assert.assertEquals(expectedResult1,ArrayProblems.lessSimpleFizzBuzz(3, 5));
        Assert.assertEquals(expectedResult2,ArrayProblems.lessSimpleFizzBuzz(5, 15));
        Assert.assertEquals(expectedResult3,ArrayProblems.lessSimpleFizzBuzz(9, 12));
    }

    @Test
    public void maxSpanTest(){
        int[] expectedResults = {4, 6, 6, 4, 4, 0};
        int[][] inputs = {{1, 2, 1, 1, 3}, {1, 4, 2, 1, 4, 1, 4}, {1,4, 2, 1, 4, 4, 4}, {1, 4, 2, 3, 4},
                {3, 3, 3, 3}, {}, {1, 2, 3, 4}};
        for(int i = 0; i < expectedResults.length; i++){
            Assert.assertEquals(expectedResults[i], ArrayProblems.maxSpan(inputs[i]));
        }
    }

    @Test
    public void maxSpanEfficientTest() {
        int[] expectedResults = {4, 6, 6, 4, 4, 0};
        int[][] inputs = {{1, 2, 1, 1, 3}, {1, 4, 2, 1, 4, 1, 4}, {1,4, 2, 1, 4, 4, 4}, {1, 4, 2, 3, 4},
                {3, 3, 3, 3}, {}, {1, 2, 3, 4}};
        for(int i = 0; i < expectedResults.length; i++) {
            Assert.assertEquals(expectedResults[i], ArrayProblems.maxSpanEfficient(inputs[i]));
        }
    }

    @Test
    public void countOccurrencesTest() {
        int[][] expectedResults = {{1, 1, 1, 2, 1, 2}, {0}};
        int[][] inputs = {{2, 3, 200, 3, 4, 200}, {}};
        for(int i = 0; i < expectedResults.length; i++) {
            Assert.assertArrayEquals(expectedResults[i], ArrayProblems.countOccurrences(inputs[i]));
        }
    }

    @Test
    public void countOccurrencesOptimizedTest() {
        int[][] expectedResults = {{1, 1, 1, 2, 1, 2}, {0}};
        int[][] inputs = {{2, 3, 200, 3, 4, 200}, {}};
        for(int i = 0; i < expectedResults.length; i++) {
            Assert.assertArrayEquals(expectedResults[i], ArrayProblems.countOccurrencesOptimized(inputs[i]));
        }
    }

    @Test
    public void countOccurrencesUnoptimizedTest() {
        int[][] expectedResults = {{1, 1, 1, 2, 1, 2}, {0}};
        int[][] inputs = {{2, 3, 200, 3, 4, 200}, {}};
        for(int i = 0; i < expectedResults.length; i++) {
            Assert.assertArrayEquals(expectedResults[i], ArrayProblems.countOccurrencesUnoptimized(inputs[i]));
        }
    }

    @Test
    public void countOccurrencesUnoptimized2Test() {
        int[][] expectedResults = {{1, 1, 1, 2, 1, 2}, {0}};
        int[][] inputs = {{2, 3, 200, 3, 4, 200}, {}};
        for(int i = 0; i < expectedResults.length; i++) {
            Assert.assertArrayEquals(expectedResults[i], ArrayProblems.countOccurrencesUnoptimized2(inputs[i]));
        }
    }

    @Test
    public void fix34Test() {
        ArrayList<Integer> expectedResult1 = new ArrayList<>(List.of(1,3,4,1));
        ArrayList<Integer> expectedResult2 = new ArrayList<>(List.of(1,3,4,1,1,3,4));
        ArrayList<Integer> expectedResult3 = new ArrayList<>(List.of(3,4,2,2));
        Assert.assertEquals(expectedResult1, ArrayProblems.fix34(new int[] {1,3,1,4}));
        Assert.assertEquals(expectedResult2, ArrayProblems.fix34(new int[] {1,3,1,4,4,3,1}));
        Assert.assertEquals(expectedResult3, ArrayProblems.fix34(new int[] {3,2,2,4}));
    }

    @Test
    public void fix34OptimizedTest() {
        int[][] expectedResults = {{1,3,4,1}, {1,3,4,1,1,3,4}, {3,4,2,2}};
        int[][] inputs = {{1,3,1,4}, {1,3,1,4,4,3,1}, {3,2,2,4}};
        for(int i = 0; i < expectedResults.length; i++) {
            Assert.assertArrayEquals(expectedResults[i], ArrayProblems.fix34Optimized(inputs[i]));
        }
    }

    @Test
    public void fix34AltTest() {
        int[][] expectedResults = {{1,3,4,1}, {1,3,4,1,1,3,4}, {3,4,2,2}};
        int[][] inputs = {{1,3,1,4}, {1,3,1,4,4,3,1}, {3,2,2,4}};
        for(int i = 0; i < expectedResults.length; i++) {
            Assert.assertArrayEquals(expectedResults[i], ArrayProblems.fix34Alt(inputs[i]));
        }
    }
}
