package main.java.LinkedListExamples;

public class LinkedListProblems {

    public static boolean findElement(int target, LinkedListNode root) {
        LinkedListNode current = root;
        while(current != null) {
            if(current.getData() == target)
                return true;
            current = current.getNext();
        }
        return false;
    }

    // given 1->1->2->3 ===> 1->2->3
    public static void removeDuplicates(LinkedListNode root) {

    }
}
