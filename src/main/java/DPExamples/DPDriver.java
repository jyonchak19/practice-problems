package main.java.DPExamples;

// TODO: TDD (Test Driven Development)
public class DPDriver {

    // measuring execution time example:
    // long startTime = System.nanoTime();
    // functionToTime();
    // long endTime = System.nanoTime();
    // long duration = (endTime - startTime) //

    public static void main(String[] args) {
        int[] amountList = {11, 76};
        int[][] coinList = {{1, 2, 5}, {2, 5, 10, 25}};
        int[] outputList = {3, 7};

        for(int i = 0; i < amountList.length; i++) {
            System.out.println("amount: " + amountList[i]);
            System.out.println("coin list first coin: " + coinList[i][0]);
            System.out.println("coinChangeIterative output: " + DPProblems.coinChangeIterative(coinList[i], amountList[i]));
            System.out.println("Expected output: " + outputList[i]);
        }
    }

    public static void fibTest() {
        int[] nList = {20, 40, 80, 100, 1000, 10000, 100000, 1000000, 1000000000};
        for (int i = 0; i < nList.length; i++) {
            System.out.println("N: " + nList[i]);
//            long startTime = System.nanoTime();
//            System.out.println("Fib recursive: " + DPProblems.fibonacciRecursive(nList[i]));
//            long endTime = System.nanoTime();
//            long duration = (endTime - startTime)/1000000;
//            System.out.println("Recursive duration (ms): " + duration);

            long startTime = System.nanoTime();
            System.out.println("Fib DP: " + DPProblems.fibonacciDP(nList[i]));
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000;
            System.out.println("DP duration (ms): " + duration);
            System.out.println();
            System.out.println();
        }
    }

    public static void coinChangeTest(){
        int[] nList = {11, 76};
        int[][] coinList = {{1, 2, 5}, {2, 5, 10, 25}};
        int[] outputList = {3};

        for(int i = 0; i < nList.length; i++) {
            System.out.println("N: " + nList[i]);
            System.out.println("coinChange output: " + DPProblems.coinChange(nList[i], coinList[i]));
            System.out.println("Expected output: " + outputList[i]);
        }
    }
}
