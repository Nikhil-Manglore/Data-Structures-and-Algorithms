public class SortingAlgorithms {


    // Insertion Sort
    private void insertionSort(int[] inputArray) {

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i; j > 0; j--) {
                if(inputArray[j] < inputArray[j-1]) {
                    swap(j, j-1, inputArray);
                }
            }
        }
    }

    private void selectionSort(int[] inputArray) {
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


    private void swap(int x, int y, int[] inputArray) {
        int temp = inputArray[x];
        inputArray[x] = inputArray[y];
        inputArray[y] = temp;
    }

    public static void main(String[] args) {
        int[] input = new int[]{9,8,7,6,5,4,3,2,1};
        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();
        sortingAlgorithms.selectionSort(input);

        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }
}
