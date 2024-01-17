class Solution {
    public boolean isMonotonic(int[] nums) {
        // determine the rule (increasing or decreasing)
        int factor = (nums[0] < nums[nums.length - 1]) ? 1 : -1;
        
        // check each value against the previous value, times the factor
        // if the rule is supposed to be decreasing, then the factor makes 
        // every value negative so it ends up increasing instead
        for (int i = 1; i < nums.length; i ++) {
            if ((nums[i-1] * factor) > (nums[i] * factor)) return false;
        }
        // if the loop survives, then the array is monotonic
        return true;
    }
}