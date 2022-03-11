package main.java.LinkedListExamples;

import java.util.HashSet;

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
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode current = root;
        LinkedListNode previous = root;
        while (current != null) {
            if (set.contains(current.getData())) {
                previous.setNext(current.getNext());
            } else {
                set.add(current.getData());
                previous = current;
            }
            current = current.getNext();
        }
    }

    public static boolean isPalindrome(LinkedListNode root) {
        LinkedListNode reverse = LinkedListNode.cloneAndReverseList(root);
        return root.listIsEqual(reverse);
    }
}
