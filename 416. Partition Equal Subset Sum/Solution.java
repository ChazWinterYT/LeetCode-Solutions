class Solution {
    public boolean canPartition(int[] nums) {
        // The target sum is exactly half the sum of the entire array
        int targetSum = 0;
        for (int x : nums) {
            targetSum += x;
        }
        if (targetSum % 2 != 0) return false;
        targetSum /= 2;
        
        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true;
        
        for (int num : nums) {
            for (int j = targetSum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        
        return dp[targetSum];
    }
}