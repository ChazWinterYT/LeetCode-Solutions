class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int mid = 0;
        int right = nums.length - 1;

        while (mid <= right) {
            if (nums[mid] == 0) { // red
                swap(nums, left, mid);
                left++;
                mid++;
            } else if (nums[mid] == 2) { // blue
                swap(nums, right, mid);
                right--;
            } else { // nums[mid] == 1, white
                mid++;
            }
        }
    }

    //helper method to swap elements
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}