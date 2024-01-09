class Solution {
    public boolean canJump(int[] nums) {
        int smallestIndex = nums.length-1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] >= smallestIndex - i) {
                smallestIndex = i;
            }
        }
        return (smallestIndex == 0);
    }
}