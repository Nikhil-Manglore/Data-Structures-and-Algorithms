import java.util.Arrays;

// Implementation for a Max Binary Heap (Max Priority Queue)
// Time complexity: O(nlog(n))
// Insert operation: O(n)
// Swim up and sink down: O(log(n)
// Get min value: O(1)
public class BinaryMaxHeap {
    int capacity = 10;
    int numOfItems = 0;
    int[] maxHeap = new int[capacity];

    // Inserts a value into the max heap.
    public void insert(int value) {
        validateCapacity();
        maxHeap[numOfItems++] = value;
        swimUp();
    }

    // Moves a leaf node up into its correct position.
    private void swimUp() {
        int index = numOfItems - 1;

        while(hasParent(index) && parentValue(index) < maxHeap[index]) {
            swap(getParent(index), index);
            index = getParent(index);
        }
    }

    // Moves the root node down into its correct position.
    private void sinkDown() {
        int index = 0;

        while(hasLeftChild(index)) {
            int maxValue = getLeftChild(index);
            if(hasRightChild(index) && rightChildValue(index) > leftChildValue(index)) {
                maxValue = getRightChild(index);
            }

            if(maxHeap[index] < maxHeap[maxValue]) {
                swap(index, maxValue);
            } else {
                break;
            }

            index = maxValue;
        }
    }

    // Removes the max value from the max heap.
    private int pop() {
        if (numOfItems == 0) {
            throw new IllegalArgumentException();
        }

        int maxValue = maxHeap[0];
        maxHeap[0] = maxHeap[numOfItems - 1];
        numOfItems--;
        sinkDown();
        return maxValue;
    }

    // Displays the max value from the max heap.
    private int peek() {
        if (numOfItems == 0) {
            throw new IllegalArgumentException();
        }
        return maxHeap[0];
    }

    // Gets the right child index
    private int getRightChild(int index) {
        return 2 * index + 2;
    }

    // Gets the left child index.
    private int getLeftChild(int index) {
        return 2 * index + 1;
    }

    // Gets the parent index.
    private int getParent(int index) {
        return (index - 1) / 2;
    }

    // Gets the value of the right child.
    private int rightChildValue(int index) {
        return maxHeap[getRightChild(index)];
    }

    // Gets the value of the left child.
    private int leftChildValue(int index) {
        return maxHeap[getLeftChild(index)];
    }

    // Gets the value of the parent child.
    private int parentValue(int index) {
        return maxHeap[getParent(index)];
    }

    // Checks if a right child exists.
    private boolean hasRightChild(int index) {
        return getRightChild(index) < numOfItems;
    }

    // Checks is a left child exists.
    private boolean hasLeftChild(int index) {
        return getLeftChild(index) < numOfItems;
    }

    // Checks if a parent value exists.
    private boolean hasParent(int index) {
        return getParent(index) >= 0;
    }

    // Swaps two values within an array.
    private void swap(int indexOne, int indexTwo) {
        int temp = maxHeap[indexOne];
        maxHeap[indexOne] = maxHeap[indexTwo];
        maxHeap[indexTwo] = temp;
    }

    // Validates if the array has space.
    private void validateCapacity() {
        if (capacity == numOfItems) {
            maxHeap = Arrays.copyOf(maxHeap, capacity * 2);
            capacity *= 2;
        }
    }
}
