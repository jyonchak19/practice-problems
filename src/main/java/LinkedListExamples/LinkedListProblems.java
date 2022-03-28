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

    // ex: the number 123 will be represented by the LinkedList: root1 = 1-> 2-> 3
    // the number 8 would just be: root2 = 8 -> null
    // the sum 123 + 8 = 131 ex: return 1 -> 3 -> 1
    // hint: int a = Integer.parseInt(Integer.toString(9) + Integer.toString(10));
    // hint: String strNumber = String.valueOf(someIntVar);
    // hint: char[] digits = strNumber.toCharArray();
    // hint: int someInt = Character.getNumericValue(someChar);
    // % 10, / 10 => ?? (reversed)
    public static LinkedListNode sumLinkedLists(LinkedListNode root1, LinkedListNode root2) { // N, M, sum(M&N)
        int sum = sumLinkedListsHelper(root1) + sumLinkedListsHelper(root2);
        char[] charDigits = String.valueOf(sum).toCharArray();
        int[] intDigits = new int[charDigits.length];
        for(int i = 0; i < charDigits.length; i++) {
            intDigits[i] = Character.getNumericValue(charDigits[i]);
        }
        return LinkedListNode.createList(intDigits);
    }

    public static int sumLinkedListsHelper(LinkedListNode root){
        LinkedListNode current = root;
        StringBuilder linkedListString = new StringBuilder();
        while(current != null) {
            linkedListString.append(current.getData());
            current = current.getNext();
        }
        return Integer.parseInt(linkedListString.toString());
    }

    // for the harder version, you cannot use any Java lib built-in functions as helpers
    // to simplify this somewhat, the input lists are in reverse (hint!!)
    // don't worry about negatives
    //   1 ->   1
    // + 9 ->   9
    //          0
    // carry = 0
    //   2 -> 4 -> 3 (342)
    // + 5 -> 6 -> 4 (465)
    // ---------------------
    //   7 -> 0 -> 8 (807) (resultant list is also reversed)
    // add each digit starting from left. to carry, take mod 10 of result, and add that to next sum
    public static LinkedListNode sumLinkedListsHard(LinkedListNode root1, LinkedListNode root2) {
        LinkedListNode current1 = root1;
        LinkedListNode current2 = root2;
        int carry = 0;
        LinkedListNode curr = null;
        
        while(current1 != null || current2 != null || carry != 0) {
            curr = new LinkedListNode(0);
            int sum = (current1.getData() + current2.getData()) % 10 + carry;
            curr.setData(sum);
            carry = (current1.getData() + current2.getData()) / 10;
            current1 = current1.getNext();
            current2 = current2.getNext();
        }
        return curr;
    }
}
