package DPExamples;


// what is DP? Dynamic Programming is mostly an optimization over recursion

public class DPProblems {


    // recursive method that returns the fibonacci result where n is the number in the order
    // 0, 1, 1, 2, 3, 5, 8 ...

    // fib[n] = fib[n-1] + fib[n-2]
    public static int fibonacciRecursive(int n) { // n = 7
        if(n == 0 || n == 1)
            return n;
        return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    }

    public static int fibonacciDP(int n) {
        int[] dp = new int[n+2];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
