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

    @Test
    public void sumLinkedListsTestSimple() {
        sumLinkedListsTestHelper(new int[]{1,2,3}, new int[]{8}, new int[]{1,3,1});
    }

    public void sumLinkedListsTestHelper(int[] input1, int[] input2, int[] expectedResult) {
        LinkedListNode list1 = LinkedListNode.createList(input1);
        LinkedListNode list2 = LinkedListNode.createList(input2);
        LinkedListNode expectedList = LinkedListNode.createList(expectedResult);
        Assert.assertTrue(LinkedListProblems.sumLinkedLists(list1, list2).listIsEqual(expectedList));
    }

    @Test
    public void sumLinkedListsHardTestSimple() {
        sumLinkedListsHardTestHelper(new int[]{2,4,3}, new int[]{5,6,4}, new int[]{7,0,8});
    }

    @Test
    public void sumLinkedListsHardTestInputDifferent() {
        sumLinkedListsHardTestHelper(new int[]{2,4,3}, new int[]{5}, new int[]{7,4,3});
    }

    @Test
    public void sumLinkedListsHardTestSingle() {
        sumLinkedListsHardTestHelper(new int[]{7}, new int[]{4}, new int[] {1,1});
    }

    @Test
    public void sumLinkedListsHardTestManyCarries() {
        sumLinkedListsHardTestHelper(new int[]{9,9,9,9,9}, new int[]{2,7,6,3,2}, new int[]{1,7,6,3,2,1});
    }

    public void sumLinkedListsHardTestHelper(int[] input1, int[] input2, int[] expectedResult) {
//          Collections.reverse(Arrays.asList(myArray));
////        Collections.reverse(Arrays.asList(input1));
////        Collections.reverse(Arrays.asList(input2));
////        Collections.reverse(Arrays.asList(expectedResult));
////        System.out.println("Input1: " + Arrays.toString(input1));
////        System.out.println("Input2: " + Arrays.toString(input2));
////        System.out.println("expectedResult: " + Arrays.toString(expectedResult));
        LinkedListNode list1 = LinkedListNode.createList(input1);
        LinkedListNode list2 = LinkedListNode.createList(input2);
        LinkedListNode expectedList = LinkedListNode.createList(expectedResult);
        Assert.assertTrue(LinkedListProblems.sumLinkedListsHard(list1, list2).listIsEqual(expectedList));
    }

    @Test
    public void kthToLastTestSimple() {
        LinkedListNode head = LinkedListNode.createList(new int[]{1,2,3,4,5});
        int k = 2;
        LinkedListNode expectedResult = LinkedListNode.createList(new int[]{3,4,5});
        kthToLastTestHelper(head, k, expectedResult);
    }

    @Test
    public void kthToLastNull() {
        LinkedListNode head = LinkedListNode.createList(new int[]{});
        int k = 2;
        kthToLastTestHelper(head, k, null);
    }

    @Test
    public void kthToLastGreaterThanLengthTest() {
        LinkedListNode head = LinkedListNode.createList(new int[]{1,2,3,4,5});
        int k = 9;
        kthToLastTestHelper(head, k, null);
    }

    @Test
    public void kthToLastSameLengthTest() {
        LinkedListNode head = LinkedListNode.createList(new int[]{1,2,3,4,5});
        int k = 4;
        LinkedListNode expectedResult = LinkedListNode.createList(new int[]{1,2,3,4,5});
        kthToLastTestHelper(head, k, expectedResult);
    }

    public void kthToLastTestHelper(LinkedListNode head, int k, LinkedListNode expectedResult) {
        LinkedListNode result = LinkedListProblems.kthToLast(head, k);
        if (result != null) {
            Assert.assertEquals(result.getData(), expectedResult.getData());
        } else {
            Assert.assertNull(expectedResult);
        }
    }
//---------------------------------------------------------------------------------------------------
    @Test
    public void kthToLastRecursiveTestSimple() {
        LinkedListNode head = LinkedListNode.createList(new int[]{1,2,3,4,5});
        int k = 2;
        LinkedListNode expectedResult = LinkedListNode.createList(new int[]{3,4,5});
        kthToLastRecursiveTestHelper(head, k, expectedResult);
    }

    @Test
    public void kthToLastRecursiveTestNull() {
        LinkedListNode head = LinkedListNode.createList(new int[]{});
        int k = 2;
        kthToLastRecursiveTestHelper(head, k, null);
    }

    @Test
    public void kthToLastRecursiveGreaterThanLengthTest() {
        LinkedListNode head = LinkedListNode.createList(new int[]{1,2,3,4,5});
        int k = 9;
        kthToLastRecursiveTestHelper(head, k, null);
    }

    @Test
    public void kthToLastRecursiveSameLengthTest() {
        LinkedListNode head = LinkedListNode.createList(new int[]{1,2,3,4,5});
        int k = 4;
        LinkedListNode expectedResult = LinkedListNode.createList(new int[]{1,2,3,4,5});
        kthToLastRecursiveTestHelper(head, k, expectedResult);
    }

    public void kthToLastRecursiveTestHelper(LinkedListNode head, int k, LinkedListNode expectedResult) {
        LinkedListNode result = LinkedListProblems.kthToLastRecursive(head, k);
        if (result != null) {
            Assert.assertEquals(result.getData(), expectedResult.getData());
        } else {
            Assert.assertNull(expectedResult);
        }
    }

    //------------------------------------------------------------------------------

    @Test
    public void kthToLastOnePassTestSimple() {
        LinkedListNode head = LinkedListNode.createList(new int[]{1,2,3,4,5});
        int k = 2;
        LinkedListNode expectedResult = LinkedListNode.createList(new int[]{3,4,5});
        kthToLastOnePassTestHelper(head, k, expectedResult);
    }

    @Test
    public void kthToLastOnePassTestNull() {
        LinkedListNode head = LinkedListNode.createList(new int[]{});
        int k = 2;
        kthToLastOnePassTestHelper(head, k, null);
    }

    @Test
    public void kthToLastOnePassGreaterThanLengthTest() {
        LinkedListNode head = LinkedListNode.createList(new int[]{1,2,3,4,5});
        int k = 9;
        kthToLastOnePassTestHelper(head, k, null);
    }

    @Test
    public void kthToLastOnePassSameLengthTest() {
        LinkedListNode head = LinkedListNode.createList(new int[]{1,2,3,4,5});
        int k = 4;
        LinkedListNode expectedResult = LinkedListNode.createList(new int[]{1,2,3,4,5});
        kthToLastOnePassTestHelper(head, k, expectedResult);
    }

    public void kthToLastOnePassTestHelper(LinkedListNode head, int k, LinkedListNode expectedResult) {
        LinkedListNode result = LinkedListProblems.kthToLastOnePass(head, k);
        if (result != null) {
            Assert.assertEquals(expectedResult.getData(), result.getData());
        } else {
            Assert.assertNull(expectedResult);
        }
    }
}
