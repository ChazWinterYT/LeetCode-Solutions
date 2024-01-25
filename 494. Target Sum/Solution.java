class Solution {
    int totalExpressions = 0;
    int[] nums;
    int target;
    
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        
        // Can be solved two ways. Decide which method to use.
        boolean useDp = false;  // true: Dynamic Programming. false: Backtracking.
        if (useDp) {
            return -1;
        } else {
            backtrack(0, 0);
        }
        return totalExpressions;
    }
    
    private void backtrack(int index, int sum) {
        // Base case: when we've used all the numbers, if the target has been reached, count this path.
        if (index == nums.length) {
            if (sum == target) totalExpressions++;
            return;
        } 
        
        // Choose addition
        backtrack(index + 1, sum + nums[index]);
        
        // Choose subtraction
        backtrack(index + 1, sum - nums[index]);
    }
}