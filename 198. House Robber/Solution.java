class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        
        int length = nums.length;
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            int dontRob = dp[i-1];
            int rob = dp[i-2] + nums[i];
            
            dp[i] = (rob > dontRob) ? rob : dontRob;
        }
        
        return dp[length-1];
    }
}