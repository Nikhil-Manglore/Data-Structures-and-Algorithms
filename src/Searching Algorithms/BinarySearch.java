public class BinarySearch {

    // Binary Search is a Divide and Conquer Algorithm 
    // Time Complexity: O(nlogn); Space Complexity: O(1);

    private int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int leftPointer, int rightPointer) {

        int middle = leftPointer + (rightPointer - leftPointer) / 2;

        if (rightPointer < leftPointer) {
            return -1;
        }

        if (nums[middle] < target) {
            return binarySearch(nums, target, middle + 1, rightPointer);
        } else if (nums[middle] > target) {
            return binarySearch(nums, target, leftPointer, middle - 1);
        }

        return middle;

    }
}
