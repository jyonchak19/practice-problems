package test.java.InterviewQuestions;

import org.junit.Test;
import org.junit.Assert;
import main.java.InterviewProblems.InterviewQuestions;

public class InterviewQuestionsTest {
    @Test
    public void maxSubArrayTest1() {
        int[] input = {5, 4, -1, 7, 8};
        int expectedResult = 23;
        Assert.assertEquals(expectedResult,
                InterviewQuestions.maxSubArray(input));
    }
    @Test
    public void maxSubArrayTest2() {
        int[] input = {-2, -1, -3, 4, -1, 2, 1, -5, 4};
        int expectedResult = 6;
        Assert.assertEquals(expectedResult,
                InterviewQuestions.maxSubArray(input));
    }
    @Test
    public void maxSubArrayTest3() {
        int[] input = {-5, -7, -3, -1, -9, -2};
        int expectedResult = -1;
        Assert.assertEquals(expectedResult,
                InterviewQuestions.maxSubArray(input));
    }
    @Test
    public void maxSubArrayRecursiveTest1() {
        int[] input = {-2, -1, -3, 4, -1, 2, 1, -5, 4};
        int expectedResult = 6;
        Assert.assertEquals(expectedResult,
                InterviewQuestions.maxSubArrayRecursive(input));
    }
    @Test
    public void maxSubArraySlidingTest1() {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int expectedResult = 16;
        Assert.assertEquals(expectedResult,
                InterviewQuestions.maxSubArraySliding(arr, k));
    }
}
