package test.java.StringExamples;

import main.java.StringExamples.StringProblems;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class StringProblemsTest {
    private String[][] inputs;
    private boolean[] expectedResults;
    @Before
    public void setupRotation() {
        inputs = new String[][]{{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"apple", "lpeap"},
                {"", ""}, {"", "a"}, {"apple", "apple"}};
        expectedResults = new boolean[]{true, true, false, true, false, true};
    }

    @Test
    public void minCatTest() {
        String[][] inputs = {{"hello", "hi"}, {"hello", "java"}, {"java", "hello"}, {"amber", "alert"},
                {"cat", "catastrophe"}, {"catastrophe", "cat"}, {"a", "alert"}, {"alert", "a"}};
        String[] expectedResult = {"lohi", "ellojava", "javaello", "amberalert", "catphe", "phecat", "at", "ta"};
        for(int i = 0; i < expectedResult.length; i++){
            Assert.assertEquals(StringProblems.minCat(inputs[i][0], inputs[i][1]), expectedResult[i]);
        }
    }

    @Test
    public void repeatNTest() {
        String[] strInputs = {"hello", "hello", "cat", "dog", "", "car"};
        int[] nInputs = {3, 2, 3, 4, 3, 0};
        String[] expectedResults = {"llollollo", "lolo", "catcatcat", "dogdogdogdog", "", ""};
        for(int i = 0; i < expectedResults.length; i++)
            Assert.assertEquals(StringProblems.repeatN(strInputs[i], nInputs[i]), expectedResults[i]);
    }

    @Test
    public void sumDigitsTest() {
        String[] inputs = {"aa1bc2bd3", "milk"};
        int[] expectedResults = {6, 0};
        for(int i = 0; i < expectedResults.length; i++)
            Assert.assertEquals(StringProblems.sumDigits(inputs[i]), expectedResults[i]);
    }

    @Test
    public void countTripleTest() {
        String[] inputs = {"abcxxxabc", "xxxabyyyycd", "ab"};
        int[] expectedResults = {1, 2, 0};
        for(int i = 0; i < expectedResults.length; i++)
            Assert.assertEquals(expectedResults[i], StringProblems.countTriple(inputs[i]));
    }

    @Test
    public void maxRepeatTest() {
        String[] inputs = {"hoopla", "abbCCCddBBBxx"};
        int[] expectedResults = {2, 3};
        for(int i = 0; i < expectedResults.length; i++)
            Assert.assertEquals(StringProblems.maxRepeat(inputs[i]), expectedResults[i]);
    }

    @Test
    public void isRotationTest() {
        String[][] inputs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"apple", "lpeap"},
                {"", ""}, {"", "a"}, {"apple", "apple"}};
        boolean[] expectedResults = {true, true, false, true, false, true};
        for(int i = 0; i < expectedResults.length; i++)
            Assert.assertEquals(expectedResults[i], StringProblems.isRotation(inputs[i][0], inputs[i][1]));
    }

    private void isRotationNum(int num) {
        Assert.assertEquals(expectedResults[num],StringProblems.isRotation(inputs[num][0], inputs[num][1]));
    }

    @Test
    public void isRotation0() {
        isRotationNum(0);
    }
    @Test
    public void isRotation1() {
        isRotationNum(1);
    }

    @Test
    public void isRotation2() {
        isRotationNum(2);
    }

    @Test
    public void isRotation3() {
        isRotationNum(3);
    }

    @Test
    public void isRotation4() {
        isRotationNum(4);
    }

    @Test
    public void isRotation5() {
        isRotationNum(5);
    }

    @Test
    public void isRotationSimplifiedTest() {
        String[][] inputs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"apple", "lpeap"},
                {"", ""}, {"", "a"}, {"apple", "apple"}};
        boolean[] expectedResults = {true, true, false, true, false, true};
        for(int i = 0; i < expectedResults.length; i++)
            Assert.assertEquals(expectedResults[i], StringProblems.isRotationSimplified(inputs[i][0], inputs[i][1]));
    }
}