package test.java.RecursionExamples;

import main.java.DPExamples.DPProblems;
import main.java.RecursionExamples.RecursionProblems;
import org.junit.Test;
import org.junit.Assert;

import java.util.Arrays;

public class RecursionProblemsTest {
    // Assert.assertEquals(someValue, otherValue)
    // Assert.assertNull(someVariable)
    // assertTrue
    @Test
    public void groupSum5Test() {
        int[][] numsInputs = {{2, 5, 10, 4}, {7, 4, 1, 10}, {10, 1, 3, 4}, {5, 1, 8, 6}, {6, 7, 10, 1, 3}, {9, 15, 1, 4}};
        int[] targetInputs = {19, 11, 11, 3, 15, 13};
        boolean[] expectedResult = {true, true, false, false, false, false};
        for(int i = 0; i < targetInputs.length; i++) {
            System.out.println("numsInput: " + Arrays.toString(numsInputs[i]));
            System.out.println("targetInput: " + targetInputs[i]);
            Assert.assertEquals(RecursionProblems.groupSum5(0, numsInputs[i], targetInputs[i]), expectedResult[i]);
        }
    }

    @Test
    public void stringCleanerTest() {
        String[] input = {"aa", "yyzzza", "hello", "abcd"};
        String[] output = {"a", "yza", "helo", "abcd"};
        for(int i = 0; i < input.length; i++) {
            System.out.println("Input: " + input[i]);
            System.out.println("stringCleaner result: " + RecursionProblems.stringCleaner(input[i]));
            Assert.assertEquals(RecursionProblems.stringCleaner(input[i]), output[i]);
        }
    }

    @Test
    public void splitOdd10Test() {
        int[][] numsInputs = {{5,5,6, 1}, {3,6,8}, {2}, {1}, {5,1,6,5}, {-5,1,6,5}, {5,5,6}};
        boolean[] expectedResult = {true, false, false, false, true, false, false};
        for(int i = 0; i < numsInputs.length; i++) {
            System.out.println("numsInput: " + Arrays.toString(numsInputs[i]));
            Assert.assertEquals(RecursionProblems.splitOdd10(numsInputs[i]), expectedResult[i]);
        }
    }

    @Test
    public void coinChangeTest1(){
        int n = 11;
        int[] coins = {1, 2, 5};
        int expectedResult = 3;
        Assert.assertEquals(expectedResult, RecursionProblems.coinChange(coins, n));
    }

    @Test
    public void coinChangeTest2() {
        int n = 76;
        int[] coins = {2, 5, 10, 25};
        int expectedResult = 7;
        Assert.assertEquals(expectedResult, RecursionProblems.coinChange(coins, n));
    }

    @Test
    public void coinChangeMemoizedTest1(){
        int n = 11;
        int[] coins = {1, 2, 5};
        int expectedResult = 3;
        Assert.assertEquals(expectedResult, RecursionProblems.coinChangeMemoized(coins, n));
    }

    @Test
    public void coinChangeMemoizedTest2() {
        int n = 76;
        int[] coins = {2, 5, 10, 25};
        int expectedResult = 7;
        Assert.assertEquals(expectedResult, RecursionProblems.coinChangeMemoized(coins, n));
    }
}
