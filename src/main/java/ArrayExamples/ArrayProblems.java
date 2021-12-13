package main.java.ArrayExamples;


import java.util.*;

public class ArrayProblems {
    // TODO implement binary search for arrays
//    public static int binarySearch(int[] arr) {
//
//    }

    // nums = [8, 1, 2, 2, 3] -> [1, 2, 3, 8]
    // returned -> [4, 0, 1, 1, 3]
    public int[] smallerNumsThanCurrent(int[] nums) {
        int[] smallerNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[j] < nums[i])
                    count++;
            }
            smallerNums[i] = count;
        }
        return smallerNums;
    }
    public int[] smallerNumsThanCurrentOpt(int[] nums) {
        int[] copy = nums.clone();
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(copy);

        // copy = [1, 2, 2, 3, 8] map {1: 0, 2:1, 3:3, 8:4}
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(copy[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            copy[i] = map.get(nums[i]);
        }
        return copy;
    }
    // [8, 1, 2, 2, 3]
    // [4, 0, 1, 1, 3]
    public int[] smallerNumsThanCurrentOptMax(int[] nums) {
        int[] count = new int[101]; // defaulted to 0
        int[] res = new int[nums.length];

        // count : [0 1 3 4 ..5.. 0]
        // (index)  0 1 2 3 ..8.. 100
        // count[1] -> the count of occurrences of 1
        for (int num: nums) { // nums: [1, 2, 2, 3, 8] i=0,1,2,3
            count[num] += 1;
        }
        // manipulate count in some way so that the value is closer
        // to what we want to return
        for (int i = 1; i <= count.length; i++) {
            count[i] += count[i-1];
        }

        // pass through nums and construct res array to return
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                res[i] = 0;
            else
                res[i] = count[nums[i] -1];
        }
        return res;
    }

    // input s = "3[ajklsdf]2[bc]" we will only have single digit numbers
    // output = "aaabcbc"
    // input s = "3[a2[c]]" // advanced
    // output = " "accaccacc"
    // "1[s]"
    // "0[s]"
    // "sdj" this input is forbidden
    // Character.getNumericValue(char c);
    // Character.isDigit(char c) -> returns true or false
    // someString.charAt(int index)

    // StringBuilder - keep in mind to reduce time complexity for adding strings

    // naive implementation: assume all input is valid, no double digit numbers
    // no nesting of expressions
    // Character.isDigit() -> return true or false
    // Integer.parseInt("43") -> 43
    // "3[a2[c]]" ->
    // "[(({}))]"
    public static String decodeStringSimple(String s) {
        int count = 0;
        boolean inBrackets = false;
        StringBuilder result = new StringBuilder();
        StringBuilder fullResult = new StringBuilder();
        StringBuilder countString = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '[') {
                inBrackets = true;
                count = Integer.parseInt(countString.toString());
                countString = new StringBuilder();
            }

           else if (s.charAt(i) == ']') {
                inBrackets = false;
                // multiply result by count and store in full result
                fullResult.append(repeatSB(result, count));
                result = new StringBuilder();
            }

           else if (!inBrackets) {
                countString.append(s.charAt(i));
            }

           else if (inBrackets) {
                result.append(s.charAt(i));
            }
            i++;
        }
        return fullResult.toString();
    }
    // "3[a2[bc1[a]]]"
    // "10[abc]2[cc]"

    // resultStack: ["", ]
    // intStack: [10, ]
    // currResult: "abc"


    public static String decodeString(String s) {
        StringBuilder currResult = new StringBuilder();
        Stack<StringBuilder> resultStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        StringBuilder countString = new StringBuilder();
        int i = 0;
        while(i < s.length()) {
            if(Character.isDigit(s.charAt(i))) {
                while(Character.isDigit(s.charAt(i))) {
                    countString.append(s.charAt(i));
                    i++;
                }
                intStack.push(Integer.parseInt(countString.toString()));
                countString = new StringBuilder();
            }
            else if (s.charAt(i) == '[') {
                resultStack.push(currResult);
                currResult = new StringBuilder();
                i++;
            }
            else if (s.charAt(i) == ']') {
                int repeatTimes = intStack.pop();
                StringBuilder temp = new StringBuilder(resultStack.pop());
                temp.append(repeatSB(currResult, repeatTimes));
                currResult = temp;
                i++;
            }
            else { // part of the string
                currResult.append(s.charAt(i++));
            }
        }
        return currResult.toString();
    }

    public static StringBuilder repeatSB(StringBuilder s, int count) {
        StringBuilder tempS = new StringBuilder(s);
        StringBuilder temp = new StringBuilder(s);
        for(int i = 0; i < count - 1; i++) {
            tempS.append(temp);
        }
        return tempS;
    }

    // int[][] -> array of arrays -> matrix
    // matrix -> [[1,2,3],[1,4,5][2,2,2]]
    // matrix[1][1]
    // int[] -> [1,2,3,4,5]

    // we want to handle edge cases (null -> null)
    // we'll return a new matrix
    // [N-j][i]
    public static int[][] rotateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return null;
        final int M = matrix.length; // row length
        final int N = matrix[0].length; // column length
        if(M != N)
            return null;
        int[][] newMatrix = new int[M][N];
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                newMatrix[j][N-1-i] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static boolean checkMatrixEquality(int[][] matrixOne, int[][] matrixTwo) {
        if(matrixOne == null && matrixTwo == null)
            return true;
        if(matrixOne == null ^ matrixTwo == null)
            return false;
        if(matrixOne.length != matrixTwo.length) // {}.length -> 0 {}
            return false;
        if(matrixOne.length == 0 && matrixTwo.length == 0)
            return true;
        if(matrixOne[0].length != matrixTwo[0].length) // {}
            return false;
        for(int i = 0; i < matrixOne.length; i++){
            for(int j = 0; j < matrixTwo.length; j++){
                if(matrixOne[i][j] != matrixTwo[i][j])
                    return false;
            }
        }
        return true;
    }

    // as input we have an N x N matrix where some of the items are 0
    // if any of the items are 0, set the entire row and column to 0.
    // items that aren't 0 will be represented by integers bw 1-9
    // input = [[1,2,3,4],
    //          [5,0,7,8],
    //          [6,1,1,2],
    //          [2,3,4,0]]

    // output [ [1,0,3,0],
    //          [0,0,0,0],
    //          [6,0,1,0],
    //          [0,0,0,0]]
    public static int[][] zeroMatrix(int[][] input) {
        final int M = input.length; // column length
        final int N = input[0].length; // row length
        boolean[][] valuesToNullify = new boolean[M][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(input[i][j] == 0)
                    valuesToNullify[i][j] = true;
            }
        }

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(valuesToNullify[i][j]){
                    nullifyRow(input, i);
                    nullifyColumn(input, j);
                }
            }
        }

        return input;
    }

    private static void nullifyRow(int[][] matrix, int row) {
        for(int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    private static void nullifyColumn(int[][] matrix, int column) {
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix[0].length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }
    }
}

