class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0.0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double result = sum / k;
        
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            result = Math.max(result, sum / k);
        }
        
        return result;
    }
}