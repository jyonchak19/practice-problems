package main.java.RecursionExamples;

import java.util.Arrays;

public class RecursionDriver {
    public static void main(String[] args) {
        int[][] numsInputs = {{2, 5, 10, 4}, {7, 4, 1, 10}, {10, 1, 3, 4}, {5, 1, 8, 6}, {6, 7, 10, 1, 3}, {9, 15, 1, 4}};
        int[] targetInputs = {19, 11, 11, 3, 15, 13};
        boolean[] expectedResult = {true, true, false, false, false, false};
        for(int i = 0; i < targetInputs.length; i++) {
            System.out.println("numsInput: " + Arrays.toString(numsInputs[i]));
            System.out.println("targetInput: " + targetInputs[i]);
            if(RecursionProblems.groupSum5(0, numsInputs[i], targetInputs[i]) == expectedResult[i])
                System.out.println("Success");
            else
                System.out.println("Failure");
        }
    }

    public static void stringCleanerTest() {
        String[] input = {"aa", "yyzzza", "hello", "abcd"};
        String[] output = {"a", "yza", "helo", "abcd"};
        for(int i = 0; i < input.length; i++) {
            System.out.println("Input: " + input[i]);
            System.out.println("stringCleaner result: " + RecursionProblems.stringCleaner(input[i]));
            if(RecursionProblems.stringCleaner(input[i]).equals(output[i]))
                System.out.println("Success");
            else
                System.out.println("Failure");
        }
    }

    public static void stringDistTest() {
        String[] input = {"catcowcat", "cataaaaaaaaaaaaaaaacataaaaaacat", "catcowcat", "cowcatcowcat", "cccatcowcatjklj"};
        String[] substrings = {"cat", "cat", "cow", "cat", "cat"};
        int[] output = {9, input[1].length(), 3, 9, 9};
        for(int i = 0; i < input.length; i++) {
            System.out.println("Input: " + input[i]);
            System.out.println("strDist result: " + RecursionProblems.strDist(input[i], substrings[i]));
            if(RecursionProblems.strDist(input[i], substrings[i]) == (output[i]))
                System.out.println("Success");
            else
                System.out.println("Failure");
        }
    }
}
