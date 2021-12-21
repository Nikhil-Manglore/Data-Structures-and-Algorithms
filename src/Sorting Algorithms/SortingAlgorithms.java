
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

    }

    // Helper Method for Heap Sort
    private void heapify() {

    }

    // Merge Sort: O(nlog(n))
    public void mergeSort(int[] inputArray) {
        int mid = inputArray.length/2;

    }

    // Quick Sort: O(n^2)
    public void quickSort() {

    }

    public void shellSort(int[] inputArray) {

    }

    // Helper Method to Swap Values in Array
    private void swap(int x, int y, int[] inputArray) {
        int temp = inputArray[x];
        inputArray[x] = inputArray[y];
        inputArray[y] = temp;
    }

    // Main
    public static void main(String[] args) {
        int[] input = new int[]{9,8,7,6,5,4,3,2,1};
        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();
        sortingAlgorithms.bubbleSort(input);

        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }
}
