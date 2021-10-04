package HeapExamples;

public class HeapDriver {

    public static void main(String[] args) {
        BinaryHeap myHeap = new BinaryHeap(15); //heapSize = 0
        myHeap.insertKey(3); // heapSize = 1
        myHeap.insertKey(2);
        myHeap.insertKey(15);

        System.out.println(myHeap.retrieveMin());
    }
}
