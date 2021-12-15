package main.java.RecursionExamples;

public class RecursionProblems {

    // recurrence relation fib: fib(n) = fib(n-1) + fib(n-2)
    public static int fibonacci (int n) {
        return 0; // TODO copy over fib
    }

    // given n, fact(n) = n * (n-1) * (n-2) * ..1
    // recurrence relation: fact(n) = n * fact(n-1)
    public static int factorial (int n) {
        if(n == 0 || n == 1)
            return 1;
        return n * factorial(n-1);
    }

    public static int bunnyEars (int bunnies) {
        if(bunnies == 0)
            return 0;
        return 2 + bunnyEars(bunnies - 1);
    }

    // bunnies are in a line with numbers for each
    // odd bunnies, 2 ears, even bunnies 3 "ears"
    public static int bunnyEarsLine (int bunnies) {
        if(bunnies == 0)
            return 0;
        if(bunnies % 2 == 0)
            return 3 + bunnyEarsLine(bunnies - 1);
        else
            return 2 + bunnyEarsLine(bunnies - 1);
    }

    // count occurences of 7 as a digit
    // ex: 717 -> 2
    // hint: mod (%) 10 can give us the rightmost digit
    // hint: dividing by 10 removes the rightmost digit
    public static int countSeven (int n) {
        if(n <= 1)
            return 0;
        if(n % 10 == 7)
            return 1 + countSeven(n / 10);
        else
            return countSeven(n / 10);
    }

    // given string and a substring (both nonempty)
    // compute recursively see if at least n copies exist (n is non-neg)
    // (including overlapping)
    // appapap, pap, 2 -> true
    public static boolean strCopies(String str, String sub, int n) {
        return n == strCopiesHelper(str, sub);
    }

    //strCopiesHelper("catatat", "at");
    //strCopiesHelper("at")
    // hint: str.substring(0,subLen).equals(sub)
    public static int strCopiesHelper(String str, String sub){
        int strLength = str.length();
        int subLength = sub.length();
        if(strLength < subLength)
            return 0;
        if(str.substring(0, subLength).equals(sub))
            return 1 + strCopiesHelper(str.substring(1), sub);
        else
            return strCopiesHelper(str.substring(1), sub);
    }

    // count the number of occurrences of the sub in str
    // (no overlapping)
    // ex: "catcowcat", "cat" -> 2
    // "appapap", "pap" -> 1
    public static int strCount(String str, String sub) {
        int strLength = str.length();
        int subLength = sub.length();
        if(strLength < subLength)
            return 0;
        if(str.substring(0, subLength).equals(sub))
            return 1 + strCount(str.substring(subLength), sub);
        else
            return strCount(str.substring(1), sub);
    }

    // "aa" -> "a"
    // "yyzzza" -> "yza"
    // "abbbcdd" -> "abcd"
    // "hello" -> "helo"
    public static String stringCleaner(String str) {
        if(str.length() < 2)
            return str;
        if(str.charAt(0) == str.charAt(1))
            return stringCleaner(str.substring(1));
        else
            return str.charAt(0) + stringCleaner(str.substring(1));
    }

    // "catcowcat", "cat" -> 9
    // "cataaaaaaaaaaaaaaaacataaaaaacat","cat"
    // "catcowcat" "cow" -> 3
    // "cowcatcowcat" "cat" -> 9
    // "cccatcowcatjklj", "cat" -> 9
    public static int strDist(String str, String sub) {
        return strDistHelper(str, sub).length();
    }


    // String str = "hello";
    // str.startsWith("he"); // returns true
    private static String strDistHelper(String str, String sub) {
        int strLen = str.length();
        int subLen = sub.length();
        if(strLen == 0)
            return str;
        if(str.substring(0, subLen).equals(sub)) {
            if(str.substring(strLen - subLen).equals(sub)) {
                return str;
            }
            else
                return strDistHelper(str.substring(0, strLen - 1), sub);
        }
        else
            return strDistHelper(str.substring(1), sub);
    }

    // recursively compute the number of times we see an 11
    // we'll only consider the part of the array in each recursion
    // that starts with the given index

    // [0 1 2 3 4], index: 1 [1 2 3 4]
    //    ^
    public int array11(int[] nums, int index) {
        if(index >= nums.length)
            return 0;
        if(nums[index] == 11)
            return 1 + array11(nums, index +1);
        else
            return array11(nums, index +1);
    }

    // this function determines whether it's possible
    // to divide the nums array into two groups where
    // the sums of each group are the same
    //[2,2] -> true
    // [2,3] -> false
    // [5,2,3] -> true
    // [2,5,3] -> true
    public boolean splitArrayIter(int[] nums) { // TODO
        int leftSum = 0;
        for(int i = 0; i < nums.length - 1; i++){
            leftSum += nums[i];
            for(int j = i + 1; j < nums.length; j++) {

            }
        }
        return false; // placeholder
    }

    public boolean splitArray(int[] nums) { // TODO
        return false; // placeholder
    }

    // TODO
    private boolean splitArrayHelper(int[] nums, int index, int leftSum, int rightSum) {
        return false; // placeholder
    }

    // this is a classic backtracking problem.
    // groupSum5(0, [2,5,10,4], 19)  -> true
    public static boolean groupSum(int start, int[] nums, int target) {
        if(start >= nums.length) {
            return target == 0;
        }
        return groupSum(start + 1, nums, target) || groupSum(start + 1, nums, target - nums[start]);
    }

    // given an array of ints, determine if it's possible to pick a subset that sum
    // to a given target. CONSTRAINT: All multiples of 5 must be included.
    // ALSO! If a value following a multiple of 5 is 1, it can't be chosen.
    // groupSum5(0, [2,5,10,4], 19)  -> true
    // groupSum5(0, [2,5,10,4], 17) -> true
    // groupSum5(0, [2,5,10,4], 12) -> false

    // todo
    public static boolean groupSum5(int start, int[] nums, int target) {
        if(start >= nums.length) {
            return target == 0;
        }
        if(!chooseIfNot1After5(start, nums))
            return groupSum5(start + 1, nums, target);
        else if(nums[start] % 5 == 0)
            return groupSum5(start + 1, nums, target - nums[start]);
        else
            return groupSum5(start + 1, nums, target) || groupSum5(start + 1, nums, target - nums[start]);
    }

    private static boolean chooseIfNot1After5(int start, int[] nums){
        if (start == 0) return true;
        return !(start > 0 && nums[start] == 1 && nums[start - 1] % 5 == 0);
    }

    // check to see if it's possible to divide nums into 2 groups
    // one group's sum is a multiple of 10, sum of the other group is odd
    // splitodd10(5,5,6, 1) -> true
    public static boolean splitOdd10(int[] nums) {
        if(nums.length == 1 || nums.length == 0)
            return false;
        return splitOdd10Helper(0, nums, 0, 0);
    }

    private static boolean splitOdd10Helper(int start, int[] nums, int sum1, int sum2) {
        if(start >= nums.length) {
            return (divisibleBy10(sum1) && isOdd(sum2)) || (isOdd(sum1) && divisibleBy10(sum2));
        }
        return splitOdd10Helper(start + 1, nums, sum1 + nums[start], sum2) ||
                splitOdd10Helper(start + 1, nums, sum1, sum2 + nums[start]);
    }

    private static boolean divisibleBy10(int num) {
        if(num == 0)
            return false;
        return num % 10 == 0;
    }

    private static boolean isOdd(int num) {
        if(num == 0)
            return false;
        return num % 2 != 0;
    }
}
