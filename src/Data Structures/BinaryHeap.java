import java.util.Arrays;

// Implementation for a Min Heap
// Time complexity: O(nlog(n))
// Insert operation: O(n)
// Swim up and sink down: O(log(n)
// Get min value: O(1)
public class BinaryHeap {
    int capacity = 10;
    int numOfItems = 0;
    int[] minHeap = new int[capacity];


    // Inserts an item into the heap.
    public void insert(int value) {
        validateCapacity();
        minHeap[numOfItems++] = value;
        swimUp();
    }

    // Reorders the heap by moving leaf node up.
    private void swimUp() {
        int index = numOfItems - 1;
        while(hasParent(index) && parentValue(index) > minHeap[index]) {
            swap(getParent(index), index);
            index = getParent(index);
        }
    }

    // Reorders the heap by moving the root node down.
    private void sinkDown() {
        int index = 0;
        while(hasLeftChild(index)) {
            int minValue = getLeftChild(index);
            if(hasRightChild(index) && leftChildValue(index) > rightChildValue(index)) {
                minValue = getRightChild(index);
            }

            if(minHeap[index] > minHeap[minValue]) {
                swap(index, minValue);
            } else {
                break;
            }
            index = minValue;

        }
    }

    // Remove the minimum value and return it.
    private int pop() {
        if(numOfItems == 0) {
            throw new IllegalArgumentException();
        }

        int minValue = minHeap[0];
        minHeap[0] = minHeap[numOfItems-1];
        numOfItems--;
        sinkDown();
        return minValue;
    }

    // Return the minimum value.
    private int peek() {
        if(numOfItems == 0) {
            throw new IllegalArgumentException();
        }

        return minHeap[0];
    }

    // Returns the index of the right child.
    private int getRightChild(int index) {
        return 2 * index + 2;
    }

    // Returns the index of the left child.
    private int getLeftChild(int index) {
        return 2 * index + 1;
    }

    // Returns the index of the parent
    private int getParent(int index) {
        return (index - 1) / 2;
    }

    // Returns the value within the array of the right child.
    private int rightChildValue(int index) {
        return minHeap[getRightChild(index)];
    }

    // Returns the value within the array of the left child.
    private int leftChildValue(int index) {
        return minHeap[getLeftChild(index)];
    }

    // Returns the value within the array of the parent.
    private int parentValue(int index) {
        return minHeap[getParent(index)];
    }

    // Checks if a left child exists.
    private boolean hasLeftChild(int index) {
        return (getLeftChild(index) < numOfItems);
    }

    // Checks if a right child exists.
    private boolean hasRightChild(int index) {
        return getRightChild(index) < numOfItems;
    }

    // Checks if a parent exists.
    private boolean hasParent(int index) {
        return getParent(index) >= 0;
    }

    // Swaps two items within min heap array.
    private void swap(int indexOne, int indexTwo) {
        int temp = minHeap[indexOne];
        minHeap[indexOne] = minHeap[indexTwo];
        minHeap[indexTwo] = temp;
    }

    // Checks if the min heap is full. If it is we will double the size of the heap.
    private void validateCapacity() {
        if(numOfItems == capacity) {
            minHeap = Arrays.copyOf(minHeap, capacity * 2);
            capacity *= 2;
        }
    }

}
