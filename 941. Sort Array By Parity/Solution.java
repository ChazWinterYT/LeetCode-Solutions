class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            if (nums[right] % 2 == 0) { //even numbers
                swap(nums, left, right);
                left++;
            }
            right++;
        }
        return nums;
    }

    //helper method to swap values
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}