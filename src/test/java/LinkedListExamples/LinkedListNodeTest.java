package test.java.LinkedListExamples;

import main.java.LinkedListExamples.LinkedListNode;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListNodeTest {
    @Test
    public void createListTest() {
        Assert.assertEquals(3, LinkedListNode.createList(new int[]{3, 2, 1}).getData());
        int[] testNums = {3, 2, 1};
        listTestHelper(testNums);
        listTestHelper(new int[]{4,3,8,4,3});
    }

    private void listTestHelper(int[] nums) {
        LinkedListNode testNode = LinkedListNode.createList(nums);
        for (int i = 0; i < nums.length; i++) {
            Assert.assertEquals(nums[i], testNode.getData());
            testNode = testNode.getNext();
        }
    }

}
