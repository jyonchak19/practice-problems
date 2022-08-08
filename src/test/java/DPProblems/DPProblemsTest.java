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
}
