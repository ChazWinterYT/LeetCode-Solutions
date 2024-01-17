class Solution {
    public void moveZeroes(int[] nums) {
        //keep a pointer at the start of the list. This is where
        //non-zero values will go (and then we will move the pointer over)
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
            }
        }
    }
}