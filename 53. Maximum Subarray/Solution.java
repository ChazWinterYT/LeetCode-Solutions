class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int maxToHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxToHere = Math.max(nums[i], maxToHere + nums[i]);
            maxSum = Math.max(maxToHere, maxSum);
        }
        return maxSum;
    }
}