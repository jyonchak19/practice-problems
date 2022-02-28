package main.java.oldExamples;

import java.util.LinkedList;

public class LInkedListExamples {
    public static void main(String[] args){
        LinkedList<String> linkedList = new LinkedList<>(); // initialize Java library linkedList
        DemoLinkedList demoList = new DemoLinkedList();

        demoList = DemoLinkedList.insert(demoList, 1);
        demoList = DemoLinkedList.insert(demoList, 2);
        demoList = DemoLinkedList.insert(demoList, 3);


        // java library linked list common operations
        linkedList.add("handbag");
        linkedList.add("normal bag");
        linkedList.addFirst("new first item");
        linkedList.addLast("new last item");

        String thirdElement = linkedList.get(3); // O(N), easier to use an array
        linkedList.set(4, "changed the fourth element"); // easier to use an array
    }
    class ListNode {
        int val;
        ListNode next;
    }

    // 1 -> 2 -> 4
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode previous = null;
        while(fast != null && fast.next != null){
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast == null)
            return previous;
        else
            return slow;
    }

    public void deleteMiddleNode(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode previous = null;
        while(fast != null && fast.next != null){
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        previous.next = slow.next;
    }


}

class DemoLinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    public static DemoLinkedList insert(DemoLinkedList list, int data) {
        Node newNode = new Node(data);

        // if empty, new node is the head
        if (list.head == null) {
            list.head = newNode;
        }
        else {
            // traverse til last node
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        return list;
    }

    public static void delete(DemoLinkedList list, int data) {
        Node temp = list.head;
        Node previous = null;
        while(temp != null && temp.data != data){
            previous = temp;
            temp = temp.next;
        }
        if(temp == null)
            return;
        // unlink the node "deleting" it
        previous.next = temp.next;
    }

    // head
    // 5(data, next) -> 4 -> 3
    // 3 -> 4 -> 5
    public static void reverse(DemoLinkedList list) {
        // traverse and grab the last element
        Node temp = list.head;
        Node previous = null;
        while(temp != null){
            Node next = temp.next;
            temp.next = previous;
            previous = temp;
            temp = next;
        }
        list.head = previous;
    }

    public static Node recursiveReverse(DemoLinkedList list) {
        return recursiveReverse(list.head, null);
    }

    public static Node recursiveReverse(Node temp, Node previous) {
        if(temp == null)
            return previous;
        Node next = temp.next;
        temp.next = previous;
        return recursiveReverse(next, temp);
    }
}