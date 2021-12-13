package main.java.oldExamples;

import java.util.ArrayList;
import java.util.Collections;
public class SortingExamples {
    public void mergesort(int[] arr) {
        int[] help = new int[arr.length];
        mergesort(arr, help, 0, arr.length-1);
    }

    // [7, 3, 9, 2, 1, 3, 0]
   //  lo                 hi

    public void mergesort(int[] arr, int[] help, int low, int high) {
        if(low < high){
            int middle = low+(high-low)/2;
            mergesort(arr, help, middle+1, high);
            mergesort(arr, help, low, middle);
            merge(arr, help, low, high, middle);
        }
    }

    public void merge(int[] arr, int[] help, int low, int high, int middle) {
        // copying our array into the helper array
        for (int i = low; i <= high; i++){
            help[i] = arr[i];
        }
        // arr  = [3, 7, 2, 9 ...]
        //               c
        // help = [3, 7, 2, 9]
        //         l    r
        int left = low;
        int right = middle+1;
        int curr = low;
        // iterating through the help array, comparing each half
        // writing the smaller elements into the orig arr
        while (left <= middle && right <= high) {
            if (help[left] <= help[right]) {
                arr[curr] = help[left];
                left++;
            }  else { // right is smaller
                arr[curr] = help[right];
                right++;
            }
            curr++;
        }
        // write back the rest of the left array
        int remain = middle - left;
        for(int i = 0; i <= remain; i++){
            arr[curr+i] = help[left + 1];
        }

        // arr [1, 2, 5,   || 2]

        // help [1 4 5   2 ]
    }

    // A= [5,6,7,8, , , , ]
    //           lastA
    // B = [1,4,9,10]
    //            lastB
    // write a method to merge B into A
    void mergeAintoB (int[] a, int[] b, int lastA, int lastB) {
        int mergedIndex = a.length;
        while(mergedIndex > lastA) {
            if(a[lastA] < b[lastB]) {
                a[mergedIndex] = b[lastB];
                lastB--;
            }
            else {
                a[mergedIndex] = a[lastA];
                lastA--;
            }
            mergedIndex--;
        }
    }


    // [ 3, 2, 19, 30, 12, 25]
    //         i
    // | 0-10 | 10-20 | 20-30 |
    //    3      19      30
    //    2      12      25
    // count sort, radix sort
    public void sortPeopleByAge(int[] ages) {
        int[] output = new int[ages.length + 1];
        int max = ages[0];
        for (int i = 1; i < ages.length; i++) {

        }
    }

    // will work for numbers between 0-255
    public void countSort(int[] arr) {
        int n = arr.length;
        int[] output = new int[n];

        // [0,0,3,4,2,2,5,6]
        //create the count array
        int count[] = new int[256]; // 0 - 255
        for (int i = 0; i < 256; i++) {
            count[i] = 0;
        }
        // storing the count of each number
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        for (int i = 1; i <= 255; i++) {
            count[i] += count[i-1];
        }

        for (int i = n -1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }

    }

    public void bucketSort(float[] arr){
        int n = 10;
        ArrayList<Float>[] bucket = new ArrayList[n];
        for(int i = 0; i < n; i++)
            bucket[i] = new ArrayList<Float>();
        for(int i = 0; i < arr.length; i++){
            int index = (int) arr[i] * 10;
            bucket[index].add(arr[i]);
        }
        for(int i = 0; i < n; i++){
            Collections.sort(bucket[i]);
        }
        int index = 0;
        for(int i = 0; i < n; i++){ // 0-9 (10 buckets)
            for(int j = 0; j < bucket[i].size(); j++){
                arr[index++] = bucket[i].get(j);
            }
        }
    }
}
