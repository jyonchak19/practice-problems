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

    public LinkedListNode getNext(){ return next; }

    public void createNext(int nextData) {
        this.next = new LinkedListNode(nextData);
    }

    // creates a LinkedList from given nums array and returns the root node
    // 3 2 1
    //   |
    public static LinkedListNode createList(int[] nums) {
        LinkedListNode head = new LinkedListNode(nums[0]);
        LinkedListNode current = head;

        for(int i = 1; i < nums.length; i++) {
            LinkedListNode next = new LinkedListNode(nums[i]);
            current.setNext(next);
            current = next;
        }
        return head;
    }

    // someListNode.listIsEqual(someOtherListNode)
    public boolean listIsEqual(LinkedListNode secondList) {
        return false;
    }

    public int getData(){
        return data;
    }
}
