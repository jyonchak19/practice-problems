package main.java.StringExamples;

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

    // hello, hi -> lohi
    // hello, java -> ellojava
    // java, hello -> javaello
    public static String minCat(String a, String b) {
        String subStr;
        if(a.length() < b.length()) {
            int dif = b.length() - a.length();
            subStr = b.substring(dif);
            return a + subStr;
        }
        else if(a.length() > b.length()){
            int dif = a.length() - b.length();
            subStr = a.substring(dif);
            return subStr + b;
        }
        else {
            return a + b;
        }
    }

    // repeatN("hello", 3) -> "llollollo"
    // repeatN("hello", 2) -> "lolo"
    public static String repeatN(String str, int n) {
        String subStr;
        if(n >= str.length())
            subStr = str;
        else
            subStr = str.substring(str.length() - n);
        return subStr.repeat(n);
    }
    // sumDigits("aa1bc2bd3") -> 6
    // sumDigits("milk") -> 0
    // hint: str.charAt, Character.isDigit(someChar), Integer.parseInt(someChar)
    public static int sumDigits(String str) {
        int sum = 0;
        for(int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i)))
                sum += Integer.parseInt(str.substring(i, i + 1));
        }
        return sum;
    }


    // abcxxxabc -> 1
    // xxxabyyyycd -> 3
    // ab -> 0
    // aaabbb
    // what if there are no overlaps allowed?
    public static int countTriple(String str) {
        int count = 0;
        for(int i = 0; i < str.length() - 2; i++) {
            if(str.charAt(i) == str.charAt(i+1) && str.charAt(i+1) == str.charAt(i+2)) {
                count++;
                i = i + 2;
            }
        }
        return count;
    }

    // hoopla -> 2
    // abbCCCddBBBxx -> 3
    public static int maxRepeat(String str) {
        int max = 0;
        int currentCount = 1;
        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == str.charAt(i-1))
                currentCount++;
            else
                currentCount = 1;
            if(currentCount > max)
                max = currentCount;
        }
        return max;
    }

    // apple, pleap -> true
    // waterbottle, erbottlewat -> true
    public static boolean isRotation(String s1, String s2) {
        if((s1.length() == 0 && s2.length() != 0) || (s1.length() != 0 && s2.length() == 0))
            return false;
        else if(s1.length() == 0 && s2.length() == 0)
            return true;
        int count;
        if(s1.length() != s2.length())
            return false;
        for(int i = 0; i < s2.length(); i++) {
            count = 0;
            StringBuilder currentString = new StringBuilder();
            for(int j = i; count < s2.length(); j++){
                if(j >= s2.length())
                    j = 0;
                currentString.append(s2.charAt(j));
                count++;
            }
            if(currentString.toString().equals(s1))
                return true;
        }
        return false;
    }

    // waterbottle, erbottlewaterbottlewat
    // apple, pleappleap
    public static boolean isRotationSimplified(String s1, String s2) {
        if(s1.length() == 0 && s2.length() != 0)
            return false;
        s2 += s2;
        return s2.contains(s1);
    }

    // edit: add a character, delete a character, change a character
    // people, peple -> true (deleted character)
    //   |       |
    // people, people -> false (0 edits)
    // peeple, people -> true (changed character)
    // peoples, people -> true (added character)
    // peeole, people -> false (two edits)
    public static boolean oneEditAway(String first, String second) {
        boolean shifted = false;
        if(first.length() - second.length() == 1) {
            return oneEditDelete(first, second);
        }
        else if(first.length() - second.length() == -1) {
            return oneEditDelete(second, first);
        }
        else if(first.length() == second.length()) {
            if(first.equals(second)) {
                return false;
            }
            else {
                return oneEditChange(first, second);
            }
        }
        else {
            return false;
        }
    }

    private static boolean oneEditDelete(String first, String second) {
        int i = 0;
        int j = 0;
        boolean shifted = false;
        while(i < first.length() && j < second.length()) {
            if(first.charAt(i) != second.charAt(j)) {
                if(!shifted){
                    shifted = true;
                    i++;
                }
                else
                    return false;
            }
            else {
                i++;
                j++;
            }
        }
        return true;
    }

    private static boolean oneEditChange(String first, String second){
        boolean changed = false;
        for(int i = 0; i < first.length(); i++) {
            if(first.charAt(i) != second.charAt(i)){
                if(changed)
                    return false;
                changed = true;
            }
        }
        return changed;
    }

    public static boolean oneEditAwayAlt(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        String s1 = first.length() < second.length() ? first: second;
        String s2 = first.length() < second.length() ? second: first;
        int i = 0, j = 0;
        boolean changed = false;
        while (j < s2.length() && i < s1.length()) {
            if (s1.charAt(i) != s2.charAt(j)) { // first change found
                if(changed)
                    return false;
                changed = true;
                if (s1.length() == s2.length())
                    i++;
            } else {
                i++;
            }
            j++;
        }
        return true;
    }

    // racecar, ogo, bob
    // carerac -> true
    // goo -> true
    // obb -> true
    // aaaabaaaa

    // ~~ pseudocode ~~
    // count the characters with odd occurrences
    // return (oddCharCount <= 1)
    // classic hashmap usage
    public static boolean isPermutedPalindrome(String s) {
        if (s == null || s.length() == 0)
            return false;
        int oddCharCount = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()) {
            if(map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        for(char c: map.keySet()) {
            if(map.get(c) % 2 != 0)
                oddCharCount++;
        }
        return oddCharCount <= 1;
    }

    // if you're limited by the ASCII character set,
    // here's a common optimization...
    // ex bogo
    // 'pattern matching' technique
    public static boolean isPermutedPalindromeOpt1(String s) {
        if (s == null || s.length() == 0)
            return false;
        // constant amount of space, O(127)
        int[] asciiCharCount = new int[128]; // 127 characters in ASCII
        // char 'a' has some int value, ex 104
        // [...0 0 0 0 ..2...]
        //  ...a b c ... o (90)...
        for (char c: s.toCharArray())
            asciiCharCount[c]++;
        int oddCharCount = 0;
        for (int count: asciiCharCount) {
            if(count % 2 != 0)
                oddCharCount++;
        }
        return oddCharCount <= 1;
    }


    // we can use the properties of a Set to solve this problem as well.
    // data structure brainstorm technique
    public static boolean isPermutedPalindromeOpt2(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i)))
                set.remove(s.charAt(i));
        }
        return set.size() <= 1;
    }

    // TODO, harder problem - Dynamic Programming
    // helloandhelloaardvark -> hello
    public static String longestRepeatingSubstring(String str) {
        return "";
    }
}
