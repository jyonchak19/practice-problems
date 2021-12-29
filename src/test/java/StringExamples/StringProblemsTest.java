package test.java.StringExamples;

import main.java.StringExamples.StringProblems;
import org.junit.Test;
import org.junit.Assert;

public class StringProblemsTest {
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
}