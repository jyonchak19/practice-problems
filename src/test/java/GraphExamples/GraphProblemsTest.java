package test.java.GraphExamples;

import main.java.graphProblems.GraphProblems;
import org.junit.Test;
import org.junit.Assert;

public class
GraphProblemsTest {
    @Test
    public void simpleNumIslandsTest() {
        char[][] input = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        int expectedResult = 3;
        Assert.assertEquals(expectedResult, GraphProblems.numIslands(input));
    }

    @Test
    public void oneNumIslandsTest() {
        char[][] input = {{'1', '1', '1', '1'}, {'1', '1', '0', '1'}, {'1', '1', '0', '0'}};
        int expectedResult = 1;
        Assert.assertEquals(expectedResult, GraphProblems.numIslands(input));
    }

    @Test
    public void simplePixelFloodFillTest() {
        int[][] inputGrid = {{1, 1, 1}, {1, 1, 3}, {1, 2, 1}};
        int x = 1;
        int y = 1;
        int newColor = 32;
        int[][] expectedResult = {{32, 32, 32}, {32, 32, 3}, {32, 2, 1}};
        Assert.assertTrue(check2dArrayEquals(expectedResult,
                GraphProblems.pixelFloodFill(inputGrid, x, y, newColor), 3, 3));
    }

    // assumes arr1 and arr2 are both m x n dimensions
    private boolean check2dArrayEquals(int[][] arr1, int[][] arr2, int m, int n) {
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(arr1[i][j] != arr2[i][j])
                    return false;
            }
        }
        return true;
    }
}
