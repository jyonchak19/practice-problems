package main.java.StackExamples;

import java.util.*;

public class StackExamples {

    public static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (char c: s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (stack.isEmpty() || stack.pop() != c)
                count++;
        }
        count += stack.size();
        return count;
    }
    // wrapping primitives
    // data structure inheritance (Abstract class Collections, ex)
    // if VS else if


}
