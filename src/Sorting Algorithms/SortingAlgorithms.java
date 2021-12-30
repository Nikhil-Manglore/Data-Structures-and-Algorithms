
public class SortingAlgorithms {

    // Insertion Sort: O(n^2)
    public void insertionSort(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i; j > 0; j--) {
                if(inputArray[j] < inputArray[j-1]) {
                    swap(j, j-1, inputArray);
                }
            }
        }
    }

    // Selection Sort: O(n^2)
    public void selectionSort(int[] inputArray) {
        for(int i = 0; i < inputArray.length-1; i++) {
            int min = i;
            for(int j = i + 1; j < inputArray.length; j++) {
                if(inputArray[j] < inputArray[min]) {
                    min = inputArray[j];
                }
            }
            swap(i, min, inputArray);
        }
    }

    // Bubble Sort: O(n^2)
    public void bubbleSort(int[] inputArray) {
        boolean repeat = true;

        while(repeat) {
            repeat = false;
            for(int i = 0; i < inputArray.length-1; i++) {
                if(inputArray[i] > inputArray[i+1]) {
                    swap(i, i+1, inputArray);
                    repeat = true;
                }
            }
        }
    }

    // Heap Sort: O(nlog(n))
    public void heapSort(int[] inputArray) {
        // TBF
    }

    // Helper Method for Heap Sort
    private void heapify() {
        // TBF
    }

    // Merge Sort: O(nlog(n))
    public void mergeSort(int[] inputArray) {
        // TBF

    }

    // Quick Sort: O(n^2)
    public void quickSort() {
        // TBF
    }

    public void shellSort(int[] inputArray) {
        // TBF
    }

    // Helper Method to Swap Values in Array
    private void swap(int x, int y, int[] inputArray) {
        int temp = inputArray[x];
        inputArray[x] = inputArray[y];
        inputArray[y] = temp;
    }

  
}
