package main.java.InterviewProblems;

public class InterviewQuestions {
    // swap the two numbers above without
    // creating a temp variable
    public static void numSwap(int x, int y) {
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
    }


    // given int arr nums, find the contiguous subarray
    // (must contain at least 1 number) that has the largest
    // sum, and return that specific sum.

    // nums = [ -2, -1, -3, 4, -1, 2, 1, -5, 4 ]
    // output: 6 bc [4, -1, 2, 1] sums to 6, the largest possible sum
    // nums [1], output: 1
    // nums = [5, 4, -1, 7, 8]
    // output: 23
    public static int maxSubArray(int[] nums) {
        int currentSum, currentMax = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length;  i++) {
            currentSum = 0;
            for(int j = i; j < nums.length; j++) {
                currentSum = currentSum + nums[j];
                if(currentMax < currentSum)
                    currentMax = currentSum;
            }
        }
        return currentMax;
    }
}
