package main.java.ArrayExamples;

public class ArrayDriver {

    public static void main(String[] args) {
        int N = 5;
        int[][] randomMatrix = randomMatrix(N, N, -5, 5);
        ArrayProblems.printMatrix(randomMatrix);
        System.out.println();
        ArrayProblems.printMatrix(ArrayProblems.zeroMatrix(randomMatrix));
    }

    public static void testZeroMatrixOne() {
        int[][] inputMatrix = {{1,2,3,4},{5,0,7,8},{6,1,1,2},{2,3,4,0}};
        int[][] outputMatrix = {{1,0,3,0}, {0,0,0,0}, {6,0,1,0}, {0,0,0,0}};

        System.out.println("Input Matrix");
        ArrayProblems.printMatrix(inputMatrix);
        System.out.println("Output Matrix");
        ArrayProblems.printMatrix(outputMatrix);

        if(ArrayProblems.checkMatrixEquality(ArrayProblems.zeroMatrix(inputMatrix), outputMatrix))
            System.out.println("zeroMatrix: Success");
        else
            System.out.println("zeroMatrix: Failure");
        System.out.println("Zero Matrix");
        ArrayProblems.printMatrix(inputMatrix);
    }
    public static void testRepeatSB() {
        StringBuilder test = new StringBuilder("abc");
        int count = 3;
        System.out.println("RepeatSB Result: "+ ArrayProblems.repeatSB(test, count));
    }

    public static void testDecodeSimple() {
        String expectedResult = "abcabcabcabcabcabcabcabcabcabccccc";
        String actualResult = ArrayProblems.decodeStringSimple("10[abc]2[cc]");


        if(expectedResult.equals(actualResult))
            System.out.println("Success :)");
        else {
            System.out.println("Failure :(");
        }
        System.out.println("Actual Result: " + actualResult);
        System.out.println("Expected Result: " + expectedResult);
    }

    public static void testDecode() {
        String expectedResult = "abcbcabcbcabcbc";
        String actualResult = ArrayProblems.decodeString("3[a2[bc]]");

        if(expectedResult.equals(actualResult))
            System.out.println("Success :)");
        else {
            System.out.println("Failure :(");
        }
        System.out.println("Actual Result: " + actualResult);
        System.out.println("Expected Result: " + expectedResult);
    }

    public static void testRotateMatrix(){
        int[][] inputMatrix = {{1,2}, {3,4}};
        int[][] expectedResultMatrix = {{3,1}, {4,2}};
        int[][] output = ArrayProblems.rotateMatrix(inputMatrix);
        if(ArrayProblems.checkMatrixEquality(output, expectedResultMatrix))
            System.out.println("rotateMatrix: Success");
        else
            System.out.println("rotateMatrix: Failure");

        int[][] matrix = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        int[][] expectedResult = {{15,13,2,5},{14,3,4,1},{12,6,8,9}, {16,7,10,11}};
        output = ArrayProblems.rotateMatrix(matrix);
        if(ArrayProblems.checkMatrixEquality(output, expectedResult))
            System.out.println("rotateMatrix: Success");
        else
            System.out.println("rotateMatrix: Failure");

        int[][] inputSimpleMatrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] expectedResultSimpleMatrix = {{7,4,1},{8,5,2},{9,6,3}};
        output = ArrayProblems.rotateMatrix(inputSimpleMatrix);
        if(ArrayProblems.checkMatrixEquality(output, expectedResultSimpleMatrix))
            System.out.println("rotateMatrix: Success");
        else
            System.out.println("rotateMatrix: Failure");

        int[][] emptyInput = {};
        int[][] emptyResult = null;
        output = ArrayProblems.rotateMatrix(emptyInput);
        if(ArrayProblems.checkMatrixEquality(output, emptyResult))
            System.out.println("rotateMatrix: Success");
        else
            System.out.println("rotateMatrix: Failure");

        int[][] nullInput = null;
        int[][] nullResult = null;
        output = ArrayProblems.rotateMatrix(nullInput);
        if(ArrayProblems.checkMatrixEquality(output, nullResult))
            System.out.println("rotateMatrix: Success");
        else
            System.out.println("rotateMatrix: Failure");

        int[][] incorrectInput = {{1}};
        int[][] incorrectResult = null;
        output = ArrayProblems.rotateMatrix(incorrectInput);
        if(ArrayProblems.checkMatrixEquality(output, incorrectResult))
            System.out.println("rotateMatrix: Success");
        else
            System.out.println("rotateMatrix: Failure");
    }

    public static void testCheckMatrixEquality(){
        int[][] inputOne = {};
        int[][] inputTwo = {};
        if(ArrayProblems.checkMatrixEquality(inputOne, inputTwo))
            System.out.println("checkMatrixEquality: Success");
        else
            System.out.println("checkMatrixEquality: Failure");
    }

    public static int[][] randomMatrix(int M, int N, int min, int max) {
        int[][] matrix = new int[M][N];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                matrix[i][j] = RandomIntInRange(min, max);
            }
        }
        return matrix;
    }

    public static int RandomIntInRange(int min, int max) {
        return randomInt(max + 1 - min) + min;
    }

    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }


}
