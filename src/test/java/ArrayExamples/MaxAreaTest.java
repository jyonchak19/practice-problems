package test.java.ArrayExamples;

import main.java.ArrayExamples.ArrayProblems;
import org.junit.Test;
import org.junit.Assert;

public class MaxAreaTest {
    @Test
    public void emptyArea() {
        Assert.assertEquals(0, ArrayProblems.maxArea(new int[] {}));
    }

    @Test
    public void standardInput() {
        Assert.assertEquals(49, ArrayProblems.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
        Assert.assertEquals(49, ArrayProblems.maxArea(new int[] {1,8,6,2,9,4,8,3,7}));
    }

    @Test
    public void maxAreaOptimizedTest() {
        Assert.assertEquals(49, ArrayProblems.maxAreaOptimized(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        Assert.assertEquals(49, ArrayProblems.maxAreaOptimized(new int[]{1, 8, 6, 2, 9, 4, 8, 3, 7}));
    }

    @Test
    public void emptyAreaOptimized() {
        Assert.assertEquals(0, ArrayProblems.maxAreaOptimized(new int[] {}));
    }
}
