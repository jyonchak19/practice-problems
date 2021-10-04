package oldExamples;

import java.util.*;

public class StackExamples {
//    public static void main(String[] args) {
//        HashMap<String, String> rafisPhonebook = new HashMap<>();
////        Scanner sc = new Scanner(System.in); // System.in standard input stream
////        System.out.print("Enter an ingredient: ");
////        String a = sc.next(); // grab the input from the user
//        rafisPhonebook.put("rafi", "2149302151");
//
//        // list of names namesList
//        ArrayList<String> namesList = new ArrayList<>(List.of("Bob", "john"));
//        for(String name: namesList) {
//            if(rafisPhonebook.containsKey(name))
//                System.out.println(rafisPhonebook.get(name));
//        }
//        rafisPhonebook.values();
//        rafisPhonebook.keySet();
//        //TODO putIfAbsent();
//        //TODO getOrDefault();
//
//    }
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>(); // LIFO
        Queue<Integer> q = new PriorityQueue<>(); // FIFO
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        // -> [1, 2, 3, 4, 5]
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        // we have five people in line to use the printer, only one can use it at a time
        // we want to print the user that is currently using the printer and use a queue
        // to maintain the line

        while(!q.isEmpty()) { // run while we have elements in the queue
            int head = q.poll();
            if(head % 2 !=  0)
            {
                System.out.println("The current user is not able to print");
            }
            else {

                System.out.println("the current person at the printer is user #: " + head);
            }
        }
        // q.poll() -> remove the head (front of the line) from the queue OR return null if empty
        // q.peek() -> retrieve the head but not remove

        while(!stack.isEmpty()){
            int top = stack.pop();
            System.out.println("(stack) the current person at the printer is user #: " + top);
        }
    }
    public static boolean validParentheses(String parentheses) {
        // "(({})))" -> invalid, "()(){}" -> valid
        Stack<Character> stack = new Stack<>();
        // ['(', ')', ... ]
        for (char c: parentheses.toCharArray()){ // (, ),
            if(c == '(')
            {
                stack.push(')');
            }
            else if (c == '{')
            {
                stack.push('}');
            }
            else if (c == '[')
            {
                stack.push(']');
            }
            else if (stack.isEmpty()){
                return false;
            }
            else if(stack.pop() != c)
            {
                return false;
            }

        }
        return stack.isEmpty();

    }
}
