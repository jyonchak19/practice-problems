package main.java.LinkedListExamples;

public class LinkedListNode {
    private int data;
    private LinkedListNode next;

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
        if(nums == null || nums.length == 0) {
            return null;
        }
        LinkedListNode head = new LinkedListNode(nums[0]);
        LinkedListNode current = head;

        for(int i = 1; i < nums.length; i++) {
            LinkedListNode next = new LinkedListNode(nums[i]);
            current.setNext(next);
            current = next;
        }
        return head;
    }

    // 4 -> 3 ->2 -> 1
    // ^
    // 4 <- 3
    public static LinkedListNode cloneAndReverseList(LinkedListNode root){
        LinkedListNode previous = null;
        while (root != null) {
            // traverse through passed in list and copy in reverse
            previous = new LinkedListNode(root.data, previous);
            root = root.next;
        }
        return previous;
    }

    // usage ex: someListNode.listIsEqual(someOtherListNode)
    public boolean listIsEqual(LinkedListNode secondList) {
        LinkedListNode first = this;
        LinkedListNode second = secondList;

        while(first != null && second != null) {
            if(first.data != second.data)
                return false;
            first = first.next;
            second = second.next;
        }
        return first == null && second == null;
    }


    public int getData(){
        return data;
    }

    public void setData(int data){this.data = data;}
}
