package main.java.LinkedListExamples;

public class LinkedListNode {
    int data;
    LinkedListNode next;

    LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

    LinkedListNode(int data, LinkedListNode nextNode) {
        this.data = data;
        this.setNext(nextNode);
    }

    // someNode.setNext(anotherNode)
    public void setNext(LinkedListNode nextNode) {
       this.next = nextNode;
    }

    public void createNext(int nextData) {
        this.next = new LinkedListNode(nextData);
    }

    // creates a LinkedList from given nums array and returns the root node
    public static LinkedListNode createList(int[] nums) {
        LinkedListNode head = new LinkedListNode(nums[0]);

        for(int i = 0; i < nums.length; i++) {

        }
    }
}
