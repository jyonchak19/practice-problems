package StringExamples;

import java.util.*;

public class StringProblems {

    // s1 = "Cat"
    // s2 = "act" -> return true
    public static boolean isPermutation(String s1, String s2) {
        if(s1.isEmpty() || s2.isEmpty() || s1.length() != s2.length())
            return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char c: s1.toCharArray()) {
            if(map1.containsKey(c))
                map1.put(c, map1.get(c) + 1);
            else
                map1.put(c, 1);
        }

        for(char c: s2.toCharArray()) {
            if(map2.containsKey(c))
                map2.put(c, map2.get(c) + 1);
            else
                map2.put(c, 1);
        }

        for(char c: map1.keySet()) {
            if(!map1.get(c).equals(map2.get(c)))
                return false;
        }
        return true;
    }

    public static boolean isPermutationOptimized(String s1, String s2) {
        if(s1.isEmpty() || s2.isEmpty() || s1.length() != s2.length())
            return false;
        int[] letters1 = new int[128]; // assumption: ASCII. in Java chars -> int ASCII value automatically
        int[] letters2 = new int[128];
        // letters[c] -> c is some char, our "hashmap"
        for(char c: s1.toCharArray()) {
            letters1[c]++;
        }
        for(char c: s2.toCharArray()) {
            letters2[c]++;
        }
        for(int i = 0; i < letters1.length; i++) {
            if(letters1[i] != letters2[i])
                return false;
        }
        return true;
    }

    public static boolean isPermutationOptimized2(String s1, String s2) {
        if(s1.isEmpty() || s2.isEmpty() || s1.length() != s2.length())
                return false;
        int[] letters = new int[256]; // modern ASCII set is 256, limited set is 128
        for(char c: s1.toCharArray()) {
            letters[c]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            letters[s2.charAt(i)]--;
            if (letters[s2.charAt(i)] < 0)
                return false;
        }
        return true;
    }

    // Why use StringBuilder > String? -> faster, consumes less memory
    // builder.toString() -> converts StringBuilder to String
    // "Mr John Smith"
    // "Mr%20John%20Smith"
    public static String replaceSpacesSimplified(String input) {
        if(input == null || input.equals(""))
            return null;
        StringBuilder result = new StringBuilder();
        for(char c: input.toCharArray()) {
            if(c != ' ')
                result.append(c);
            else
                result.append("%20");
        }
        return result.toString();
    }

    // input: " Mr John Smith   ", 13
    // output: "Mr%20John%20Smith"
    // input "joe b   ", 5
    public static String replaceSpacesWithSpecialCharacter(String input, int trueLength) {
        StringBuilder result = new StringBuilder();
        for(char c: input.substring(0, trueLength).toCharArray()) {
            if(c != ' ')
                result.append(c);
            else
                result.append("%20");
        }
        return result.toString();
    }


    // input = "aabbccccaaa" output -> "a2b2c4a3"
    //          i
    // if the "sum-compressed" string is LONGER than the original string,
    // return the original string
    public static String compressString(String input) {
        if(input == null)
            return null;
        if(input.equals(""))
            return "";
        int count = 0;
        char previousChar = input.charAt(0);
        StringBuilder outputString = new StringBuilder();
        for(int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != previousChar){
                outputString.append(previousChar);
                outputString.append(count);
                count = 0;
                previousChar = input.charAt(i);
            }
            count++;
        }
        outputString.append(previousChar);
        outputString.append(count);
        if(outputString.length() < input.length())
            return outputString.toString();
        return input;
    }

    // caaatt
    //    ||
    public static String compressStringDiff(String input) {
        int count = 1;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length() - 1; i++) {
            char currChar = input.charAt(i);
            char nextChar = input.charAt(i + 1);
            if (currChar != nextChar) {
                result.append(currChar);
                result.append(count);
                count = 1;
            }
            count++;
        }
        return result.toString();
    }
}
