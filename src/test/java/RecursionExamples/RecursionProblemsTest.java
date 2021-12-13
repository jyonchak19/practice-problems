package test.java.RecursionExamples;

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
}
