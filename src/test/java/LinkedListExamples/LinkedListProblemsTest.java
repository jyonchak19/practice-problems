package test.java.LinkedListExamples;

import main.java.LinkedListExamples.LinkedListProblems;
import main.java.LinkedListExamples.LinkedListNode;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListProblemsTest {
    @Test
    public void findElementTestPositive() {
        int[] inputArray = {3,7,2};
        int target = 7;
        LinkedListNode head = LinkedListNode.createList(inputArray);
        Assert.assertTrue(LinkedListProblems.findElement(target, head));
    }

    @Test
    public void findElementTestNegative() {
        int[] inputArray = {3,7,2};
        int target = 12;
        LinkedListNode head = LinkedListNode.createList(inputArray);
        Assert.assertFalse(LinkedListProblems.findElement(target, head));
    }

    @Test
    public void findElementTestNull() {
        int target = 7;
        Assert.assertFalse(LinkedListProblems.findElement(target, null));
    }

    @Test
    public void removeDuplicatesTestSimple() {
        int[] inputArray = {3,7,7,2};
        LinkedListNode head = LinkedListNode.createList(inputArray);

    }

    @Test
    public void removeDuplicatesTestMultiple() {

    }

    @Test
    public void removeDuplicatesTestScattered() {

    }

    @Test
    public void removeDuplicatesTestNone() {

    }
}
