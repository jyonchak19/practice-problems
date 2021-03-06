package main.java.DPExamples;


// what is DP? Dynamic Programming is mostly an optimization over recursion

public class DPProblems {


    // recursive method that returns the fibonacci result where n is the number in the order
    // 0, 1, 1, 2, 3, 5, 8 ...

    // fib[n] = fib[n-1] + fib[n-2]
    public static int fibonacciRecursive(int n) { // n = 7
        if (n == 0 || n == 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
// RECURRENCE RELATION (refresher) - an equation we use for recursion problems that represents
// the recursive step. It defines the sequence as a function
// fibonacci(n) = fibonacci(n-1) + fibonacci(n-2)

// walking through recursive tree for fibonacci
//                   f(5)
//             /           \
//            f(4)         f(3)
//         /   \           /    \
//        f(3)  f(2)     f(2)    f(1)
//       /  \
//     f(2) f(1)

// memoization - using DP by storing subproblems in a recursive problem
    public static int fibonacciDP(int n) {
        int[] dp = new int[n + 2];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // rod cutting algorithm:
    // given a rod of length n and an array that contains prices of all pieces of size smaller than n
    // determine the max value obtainable by cutting up to rod and selling the pieces.

    // n = 8, prices = [1,5,8,9,10,17,17,20]

    // length |  1  2  3  4  5  6  7  8
    // price  |  3  5  8  9  10 17 17 20
    // recurrence relation?
    public static int rodCutting(int n, int[] prices) {
        if(n == 0)
            return 0;
        int bestValue = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] / (i + 1) > bestValue)
                bestValue = prices[i] / (i + 1);
        }
        return 0; // TODO finish rod cutting
    }

    // coin change algorithm:
    // given some value N, if we want to make change for N cents - we have an array of coin denominations
    // ex: [1, 5, 10, 25, ...]
    // return the smallest amount of coins that give us N cents
    // OR find the total number of ways we can get N cents

    // input: N = 11, coins = [1,2,5]
    // output: 3
    // 11 = 5 + 5 + 1

    // Additional complication (add later): coins = [2], N = 3 -> output: -1
    public static int coinChange(int N, int[] coins) {
        if (N < 1)
            return 0;
        return coinChangeHelper(N, coins, new int[N]);
    }

    // 23 amount, [1,3,5,10]
    // [1 2 1 2,...0 0]
    //  1 2 3 4    22 23

    private static int coinChangeHelper(int remainder, int[] coins, int[] amounts) {
        if (remainder == 0)
            return 0;
        if (remainder < 0)
            return -1;
        if (amounts[remainder - 1] != 0) return amounts[remainder - 1]; // if we've precomputed
        int min = Integer.MAX_VALUE;
        for (int coin : coins) { // [1,3,5,10]
            int result = coinChangeHelper(remainder - coin, coins, amounts);
            if (result >= 0 && result < min)
                min = result + 1;
        }
        amounts[remainder - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return amounts[remainder - 1];
    }

    public static int coinChangePureRecurse(int[] coins, int amount, int coinsIndex) {
        // base cases
        if (amount == 0)
            return 1;
        if (amount < 0)
            return 0;
        if (coinsIndex <= 0) // if there are no coins
            return 0;
        // sum of solutions including and excluding coins[coinIndex-1]
        return coinChangePureRecurse(coins, amount, coinsIndex - 1)
                + coinChangePureRecurse(coins, amount - coins[coinsIndex - 1], coinsIndex);
    }

//
//                              coins = [1,2,3], amount = 5
//                       /                                     \
//             coins [1,2,3] amount = 2                    coins [1,2] amount = 5
//           /            \                             /                            \
//          0        coins [1,2] amount = 2       coins [1,2] amount = 3            coins[1] amount = 5
//                  /                \            /                   \              /              \
//               [1,2] 0              [1], 2       [1,2], 1           [1], 3        [1], 4          0
//
//
// dp =     [0,1,2,3, ... amount (51)], coins = [1,2,5]
//          0,
    public static int coinChangeIterative(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1]; // dynamic programming storage

        for (int remainder = 1; remainder <= amount; remainder++) {
            int min = -1; // -1 = flag meaning that no value is possible
            for (int coin : coins) {
                if (remainder >= coin && dp[remainder - coin] != -1) {
                    int temp = dp[remainder - coin] + 1;
                    if (min < 0 || temp < min)
                        min = temp;
                }
            }
            dp[remainder] = min;
        }
        return dp[amount];
    }
}

// KNAPSACK PROBLEM: given a set of items, each with a weight and value, determine
// the number of each item to include in a set of items where the total weight is
// less than or equal to a given limit and the value is as large as possible
// (we have a knapsack, we want the weight to be small and the value of goods to be large)


// longest common subsequence - variants of subsequence