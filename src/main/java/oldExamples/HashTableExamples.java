package main.java.oldExamples;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.*;
public class HashTableExamples {
    public static void main(String[] args) {
        HashSet<String> rafisCustomIngredientSet = new HashSet<>();
        Scanner sc = new Scanner(System.in); // System.in standard input stream
        System.out.print("Enter an ingredient: ");
        String a = sc.next(); // grab the input from the user
        rafisCustomIngredientSet.add(a);
        rafisCustomIngredientSet.add("grapes");
        rafisCustomIngredientSet.add("grapes");
        System.out.print(rafisCustomIngredientSet);
    }


     public static int numIdenticalPairs(int[] nums) {
        // TIP: .size() for Java Classes, .length for primitives (arrays)
         int pairs = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] == nums[j])
                    pairs++;
            }
        }
        return pairs;
    }

    public static int numIdenticalPairsOptimized(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int pairs = 0;
        for(int num: nums) {
            if (!map.containsKey(num)) { // the map doesn't have num
                map.put(num, 1); // add num to our map, with value of 1
            } else {
                map.put(num, map.get(num)+1); // increment our value count of that key
            }
            pairs += map.get(num) -1;
        }
        return pairs;
    }

    public int[] doubleSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(i + j == target)
                    return new int[] {i,j};
            }
        }
        return null;
    }

    public int[] doubleSumOptimized(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // number to the index {2:0, ...}
       for(int i = 0; i < nums.length; i++){
           int diff = target - nums[i];
           if(map.containsKey(diff)){ // have we seen the diff?
               return new int[] {map.get(diff), i};
           }
           else{
               map.put(nums[i], i); // store the number and its index 1st run:(2,0)
           }
       }
       return null;
    }

    public int[] smallerThanCurr(int[] nums) {
        int[] numSmaller = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int count = 0;
            for(int j = 0; j < nums.length; j++) {
                if(nums[j] < nums[i]) {
                    count++;
                }
            }
            numSmaller[i] = count;
        }
        return numSmaller;
    }



    public int[] smallerThanCurrOptimized(int[] nums) {
        int[] numSmaller = nums.clone();
        Arrays.sort(numSmaller); // O(NLogN)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(numSmaller[i], i);
        }
        for (int i = 0; i < numSmaller.length; i++) {
            numSmaller[i] = map.get(nums[i]);
        }
        return numSmaller;
    }

    public int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count, sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                count = map.get(nums[i]) + 1;
                map.put(nums[i], count);
            }
            else
                map.put(nums[i], 1);
        }
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) == 1){
                sum += nums[i];
            }
        }
        return sum;
    }

    public boolean uniqueOccurrences(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                count = map.get(nums[i]) + 1;
                map.put(nums[i], count);
            } else
                map.put(nums[i], 1);
        }
        HashSet<Integer> set = new HashSet<>(map.values());
        return (map.size() == set.size());
    }

 }
