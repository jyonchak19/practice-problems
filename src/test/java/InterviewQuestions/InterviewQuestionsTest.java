package test.java.InterviewQuestions;

import org.junit.Test;
import org.junit.Assert;
import main.java.InterviewProblems.InterviewQuestions;

public class InterviewQuestionsTest {
    @Test
    public void maxSubArrayTest() {
        int[] input = {5, 4, -1, 7, 8};
        int expectedResult = 23;
        Assert.assertEquals(expectedResult,
                InterviewQuestions.maxSubArray(input));
    }
}
