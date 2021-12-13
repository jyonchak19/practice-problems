package main.java.HeapExamples;


import java.util.Arrays;
import java.util.NoSuchElementException;

public class BinaryHeap {

    // what data structure to use?
    private static final int d = 2;
    private int[] heap;
    private int heapSize;

    public BinaryHeap(int capacity) {
        heap = new int[capacity + 1];
        heapSize = 0;
        Arrays.fill(heap, -1);
    }

    public boolean heapFull() {
        return heapSize == heap.length;
    }

    public boolean heapEmpty() {
        return heapSize == 0;
    }

    private int parent(int i) {
        return (i-1)/d;
    }
    private int kthChild(int i, int k) {
        return d*i + k;
    }

    private int minChild(int i) {
        int leftChild = kthChild(i, 1);
        int rightChild = kthChild(i, 2);
        return heap[leftChild] > heap[rightChild] ? rightChild : leftChild;
    }

    // used to maintain order while deleting (retrieving min)
    private void heapifyDown(int i) {
        int temp = heap[i];
        while(i < heapSize && temp > heap[minChild(i)]) {
            int minChild = minChild(i);
            heap[i] = heap[minChild];
            i = minChild;
        }
    }

    // used to maintain order while inserting
    private void heapifyUp(int i) {
        int temp = heap[i];
        while(i > 0 && temp > heap[parent(i)]) {
            heap[i] = heap[parent(i)];
            i = parent(i);
            heap[i] = temp;
        }
    }

    // push onto the heap a new number
    public void insertKey(int key) {
        // check to see if the heap is full
        if(heapFull())
            throw new NoSuchElementException("Heap is full!");
        // store the new key, increment heapSize
        heap[heapSize] = key;
        heapSize++;
        // call heapifyUp (reorder and optimize the heap)
        heapifyUp(heapSize - 1);
    }

    // get min and remove it from the top
    public int retrieveMin() {
        return delete(0);
    }

    public int getMin() {
        if(heapEmpty())
            throw new NoSuchElementException("Heap is empty!");
        return heap[0];
    }

    // deletes the element at index i (like pop) returns the deleted value
    public int delete(int i) {
        if(heapEmpty())
            throw new NoSuchElementException("Heap is empty!");
        int key = heap[i];
        heap[i] = heap[heapSize - 1];
        heapSize--;
        heapifyDown(i);
        return key;
    }
}

// [3   2  4]
//    2
//  3   4
// --> insert(1)

// heap[(i-1)/2] -> parent node
// heap[(i*2) + 1] -> left child node
// heap[(i*2) + 2] -> right child node

//[2 ]