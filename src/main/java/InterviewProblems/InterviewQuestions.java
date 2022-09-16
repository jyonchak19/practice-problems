package main.java.InterviewProblems;

public class InterviewQuestions {
    // swap the two numbers above without
    // creating a temp variable
    public static void numSwap(int x, int y) {
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
    }


    // ***************** KADANE'S ALGORITHM ***********************
    // given int arr nums, find the contiguous subarray
    // (must contain at least 1 number) that has the largest
    // sum, and return that specific sum.

    // nums = [ -2, -1, -3, 4, -1, 2, 1, -5, 4 ]
    // output: 6 bc [4, -1, 2, 1] sums to 6, the largest possible sum
    // nums [1], output: 1
    // nums = [5, 4, -1, 7, 8]
    // output: 23
    public static int maxSubArray(int[] nums) {
        int maxLastSeen = nums[0], maxEndedHere = nums[0];
        for(int i = 1; i < nums.length;  i++) {
            maxEndedHere = Math.max(maxEndedHere + nums[i], nums[i]);
            maxLastSeen = Math.max(maxLastSeen, maxEndedHere);
        }
        return maxLastSeen;
    }

    public static int maxSubArrayBrute(int[] nums) {
        int currentSum = 0, currentMax = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length;  i++) {
           for(int j = i; j < nums.length; j++) {
               currentSum = currentSum + nums[j];
               if(currentSum > currentMax)
                   currentMax = currentSum;
            }
        }
        return currentMax;
    }

    public static int minSubArray(int[] nums) {
        int minLastSeen = nums[0], minEndedHere = nums[0];
        for(int i = 1; i < nums.length;  i++) {
            minEndedHere = Math.min(minEndedHere + nums[i], nums[i]);
            minLastSeen = Math.min(minLastSeen, minEndedHere);
        }
        return minLastSeen;
    }

    public static int maxSubArrayRecursive(int[] nums) {
        int maxLastSeen = nums[0], maxEndedHere = nums[0];
        return maxSubArrayRecursiveHelper(nums, maxLastSeen, maxEndedHere, 1);
    }
    public static int maxSubArrayRecursiveHelper(int[] nums, int maxLastSeen, int maxEndedHere, int i) {
        if(i == nums.length)
            return maxLastSeen;
        maxEndedHere = Math.max(maxEndedHere + nums[i], nums[i]);
        maxLastSeen = Math.max(maxLastSeen, maxEndedHere);
        return maxSubArrayRecursiveHelper(nums, maxLastSeen, maxEndedHere, i + 1);
    }

    // find the maximum possible contiguous sum with k elements

    // [1,3,-1,-3,5,3,6,7] k = 3
    public static int maxSubArraySliding(int[] nums, int k) {
        int currentSum = 0, currentMax = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length;  i++) {
            for(int j = i; j + k < nums.length; j++) {
                currentSum = currentSum + nums[j];
                if(currentSum > currentMax && j - i + 1 == k)
                    currentMax = currentSum;
            }
        }
        return currentMax;
    }
}
