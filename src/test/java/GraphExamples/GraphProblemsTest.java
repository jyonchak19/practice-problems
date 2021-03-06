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

    @Test
    public void pixelFloodFillSameColorTest() {
        int[][] inputGrid = {{1, 1, 1}, {1, 1, 3}, {1, 2, 1}};
        int x = 1;
        int y = 1;
        int newColor = 1;
        int[][] expectedResult = {{1, 1, 1}, {1, 1, 3}, {1, 2, 1}};
        Assert.assertTrue(check2dArrayEquals(expectedResult,
                GraphProblems.pixelFloodFill(inputGrid, x, y, newColor), 3, 3));
    }

    @Test
    public void pixelFloodFillTest2() {
        int[][] inputGrid = {{1, 1, 1, 1}, {1, 1, 3, 5}, {1, 2, 1, 1}, {1, 1, 7, 8}};
        int x = 1;
        int y = 1;
        int newColor = 32;
        int[][] expectedResult = {{32, 32, 32, 32}, {32, 32, 3, 5}, {32, 2, 1, 1}, {32, 32, 7, 8}};
        Assert.assertTrue(check2dArrayEquals(expectedResult,
                GraphProblems.pixelFloodFill(inputGrid, x, y, newColor), 4, 4));
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

    @Test
    public void islandPerimeterTest1() {
        int[][] inputGrid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int expectedResult = 16;
        Assert.assertEquals(expectedResult, GraphProblems.islandPerimeter(inputGrid));
    }

    @Test
    public void islandPerimeterTest2() {
        int[][] inputGrid = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 1}, {1, 1, 1, 1}};
        int expectedResult = 12;
        Assert.assertEquals(expectedResult, GraphProblems.islandPerimeter(inputGrid));
    }

    @Test
    public void islandPerimeterTest3() {
        int[][] inputGrid = {{0, 0, 0, 0}, {0, 1, 1, 0}, {0, 1, 0, 1}, {1, 1, 1, 1}};
        int expectedResult = 18;
        Assert.assertEquals(expectedResult, GraphProblems.islandPerimeter(inputGrid));
    }

    @Test
    public void minKnightMovesTest1() {
        int[] start = {2,2};
        int[] target = {0,1};
        int n = 4;
        int expectedResult = 1;
        Assert.assertEquals(expectedResult, GraphProblems.minKnightMoves(start, target, n));
    }

    @Test
    public void minKnightMovesTest2() {
        int[] start = {4,5};
        int[] target = {1,1};
        int n = 5;
        int expectedResult = 3;
        Assert.assertEquals(expectedResult, GraphProblems.minKnightMoves(start, target, n));
    }

    @Test
    public void shortestDistanceBombsTest1() {
        int[][] input = {
                {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        int expectedResult = 11;
        Assert.assertEquals(expectedResult, GraphProblems.shortestDistanceBombs(input));
    }
    @Test
    public void shortestDistanceBombsTest2() {
        int[][] input =
                {
                        { 0, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
                        { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }

                };

//        { 0, 2, 1, 2, 0, 2, 1, 1, 1, 1 }  //  11, 12, 13
//        { 2, 2, 1, 2, 2, 2, 1, 2, 2, 2 }
//        { 1, 1, 1, 1, 1, 1, 1, 2, 0, 2 }
//        { 1, 1, 1, 1, 2, 2, 2, 2, 2, 2 }
//        { 1, 1, 1, 1, 2, 0, 2, 1, 1, 1 }
//        { 2, 2, 2, 1, 2, 2, 2, 1, 1, 1 }
//        { 2, 0, 2, 1, 1, 1, 1, 1, 2, 2 }
//        { 2, 2, 2, 1, 2, 2, 2, 1, 2, 0 }
//        { 1, 1, 1, 1, 2, 0, 2, 1, 2, 2 }
//        { 1, 1, 1, 1, 2, 2, 2, 1, 1, 1 }
        int expectedResult = 11;
        Assert.assertEquals(expectedResult, GraphProblems.shortestDistanceBombs(input));
    }
    @Test
    public void shortestDistanceBombsTest3() {
        int[][] input =
                {
                        {0, 1, 1, 1, 0, 1, 1, 1, 1, 1}, // 9
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
                };
        int expectedResult = 9;
        Assert.assertEquals(expectedResult, GraphProblems.shortestDistanceBombs(input));
    }

    @Test
    public void findShortestPathTest1() {
        boolean[][] input =
                {
                        {true, true, true, true, true, false, false, true, true, true},
                        {false, true, true, true, true, true, false, true, false, true},
                        {false, false, true, false, true, true, true, false, false, true},
                        {true, false, true, true, true, false, true, true, false, true},
                        {false, false, false, true, false, false, false, true, false, true},
                        {true, false, true, true, true, false, false, true, true, false},
                        {false, false, false, false, true, false, false, true, false, true},
                        {false, true, true, true, true, true, true, true, false, false},
                        {true, true, true, true, true, false, false, true, true, true},
                        {false, false, true, false, false, true, true, false, false, true}
                };
        int expectedResult = 12;
        Assert.assertEquals(expectedResult, GraphProblems.findShortestPath(input, 0, 0, 7, 5));
    }
}
