package test.java.DPProblems;

import main.java.DPExamples.DPProblems;
import org.junit.Test;
import org.junit.Assert;

public class DPProblemsTest {
    @Test
    public void uniqueRobotPathsTest1() {
        int m = 3;
        int n = 7;
        Assert.assertEquals(28, DPProblems.uniqueRobotPaths(n,m));
    }
    // m=3, n=2, output 3
    @Test
    public void uniqueRobotPathsTest2() {
        int m = 3;
        int n = 2;
        Assert.assertEquals(3, DPProblems.uniqueRobotPaths(n,m));
    }

    @Test
    public void knapsackTest1() {
        int[] values = { 60, 100, 120 };
        int[] weights = { 10, 20, 30 };
        Assert.assertEquals(220, DPProblems.knapsack(50, weights, values, 3));
    }
    @Test
    public void knapsackTest2() {
        int[] values = { 10, 15, 40 };
        int[] weights = { 1, 2, 3 };
        Assert.assertEquals(65, DPProblems.knapsack(6, weights, values, 3));
    }
    @Test
    public void knapsackTest3() {
        int[] values = { 10, 15, 40 };
        int[] weights = { 3, 7, 9 };
        Assert.assertEquals(65, DPProblems.knapsack(20, weights, values, 3));
    }

    @Test
    public void LCSTest1() {
        Assert.assertEquals(3, DPProblems.LCS("abcde", "ace"));
    }

    @Test
    public void LCSTest2() {
        Assert.assertEquals(4, DPProblems.LCS("abcdbdab", "bdcaba"));
    }

    @Test
    public void LCSTest3() {
        Assert.assertEquals(3, DPProblems.LCS("abc", "abc"));
    }
    @Test
    public void LCSTest4() {
        Assert.assertEquals(0, DPProblems.LCS("abc", "def"));
    }

    @Test
    public void dpLCSTest1() {
        Assert.assertEquals(3, DPProblems.dpLCS("abcde", "ace"));
    }
    @Test
    public void dpLCSTest2() {
        Assert.assertEquals(4, DPProblems.dpLCS("abcdbdab", "bdcaba"));
    }

    @Test
    public void dpLCSTest3() {
        Assert.assertEquals(3, DPProblems.dpLCS("abc", "abc"));
    }
    @Test
    public void dpLCSTest4() {
        Assert.assertEquals(0, DPProblems.dpLCS("abc", "def"));
    }

    @Test
    public void subsetSumTest1() {
        Assert.assertTrue(DPProblems.subsetSum(new int[]{7, 3, 2, 5, 8}, 5, 14));
    }

    // excluding 11 and including 5 and 6
    //
    @Test
    public void subsetSumTest2() {
        Assert.assertTrue(DPProblems.subsetSum(new int[]{3, 4, 5, 6, 11}, 5, 14));
    }

}
