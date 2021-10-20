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


    // 3 types of edits to a string: inserting, removing, or replacing.
    // given two strings, this function should check if they are between 0 and 1
    // edits away from each other.
    // pale -> paley -> true difference in the lengths is <= 1
    // pale -> paleye -> true difference in the lengths is > 1
    // ex: pale, ple -> true
    // ex: pale, bale -> true
    // ex pale, bake -> false
    // s1 N long, s2 M long
    public static boolean oneEditReplace(String s1, String s2) {
// TODO handle null edge case
//        if(s1 == null && s2.length() == 1)
//            return true;
//        if(s1.length() == 1 && s2 == null)
//            return true;

        int numEdits = 0;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char c: s1.toCharArray()) {
            if (map1.containsKey(c))
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

        char[] charArray;
        if(s1.length() > s2.length()) {
            charArray = s1.toCharArray();

        }
        else {
            charArray = s2.toCharArray();
        }
        for (char c : charArray) {
            if(!map1.containsKey(c) || !map2.containsKey(c))
                numEdits++;
            else if (!map1.get(c).equals(map2.get(c)))
                numEdits++;
        }
        return numEdits == 0 || numEdits == 1;
    }

    // two types of edits: insert/remove, replace
    // ~~~~ insert/remove case ~~~~
    // 1. one string is longer than the other
    //
    // s1 pale, s2 ple
    // bale, ple
    public static boolean oneEditReplaceConstantSpace(String s1, String s2) {
        int N = s1.length(), M = s2.length(), i = 0, j = 0, count = 0;
        if(Math.abs(N - M) > 1)
            return false;
        while(i < N && j < M) {
            if(s1.charAt(i) != s2.charAt(j)) { // if character mismatch found
                if (count == 1)
                    return false;
                if (N > M) {
                    i++;
                } else if (M > N) {
                    j++;
                } else {
                    i++;
                    j++;
                }
                count++;
            }
            else {
                i++;
                j++;
            }
        }
        return count == 0 || count == 1;
    }

    // palindrome: "racecar", "abba", "aba" "bab"
    // input: "babad" -> "bab" (or "aba" is also valid)
    // input: "cbbd" -> "bb"
    // input: "a" -> "a"
    // input: "ac" -> "a" (or "c")
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        String currentLongest = "";
        String substring;
        for(int i = 0; i < s.length(); i++){
            for(int j = s.length() - 1; j >= i; j--) {
                if(s.charAt(i) == s.charAt(j)) {
                    substring = s.substring(i, j + 1);
                    if(isPalindrome(substring)) {
                        if (substring.length() > currentLongest.length()) {
                            currentLongest = substring;
                        }
                    }
                }
            }
        }
        return currentLongest;
    }
    private static int lo, high;
    public static String longestPalindromeAlt(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len -1; i ++) {
            extendPalindrome(s, i, i); // assuming an odd length
            extendPalindrome(s, i, i+1); // assume even
        }
        return s.substring(lo, high);
    }
    private static void extendPalindrome(String s, int j, int k) {
        while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (high < k - j -1) {
            lo = j + 1;
            high =  k - j -1;
        }
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
