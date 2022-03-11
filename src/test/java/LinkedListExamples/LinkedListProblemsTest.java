package test.java.LinkedListExamples;

import main.java.LinkedListExamples.LinkedListProblems;
import main.java.LinkedListExamples.LinkedListNode;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListProblemsTest {
    // generate a random int array
    // create a linkedlist from that array
    // generate another array from the random int array with all dupes removed
    // random int array -> hashSet (remove dupes) ->
    // benefits of automating and randomizing our test

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

    public void removeDuplicatesHelper(int[] inputArray, int[] expectedResult) {
        LinkedListNode head1 = LinkedListNode.createList(inputArray);
        LinkedListProblems.removeDuplicates(head1);
        LinkedListNode head2 = LinkedListNode.createList(expectedResult);
        Assert.assertTrue(head1.listIsEqual(head2));
    }

    @Test
    public void removeDuplicatesTestSimple () {
        removeDuplicatesHelper(new int[]{3,7,7,2}, new int[]{3,7,2});
    }

    @Test
    public void removeDuplicatesTestMultiple() {
        removeDuplicatesHelper(new int[]{3,7,7,5,5,2}, new int[]{3,7,5,2});
    }

    @Test
    public void removeDuplicatesTestScattered() {
        removeDuplicatesHelper(new int[]{3,7,5,2,3,7}, new int[]{3,7,5,2});
    }

    @Test
    public void removeDuplicatesTestNone() {
        removeDuplicatesHelper(new int[]{4,9,1,6}, new int[]{4,9,1,6});
    }
}
