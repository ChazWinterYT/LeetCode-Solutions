class Solution {
    int totalExpressions = 0;
    int[] nums;
    int target;
    int algebraTarget;
    
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        this.algebraTarget = calculateAlgebraTarget();
        if (algebraTarget < 0 || algebraTarget % 2 != 0) return 0; // See explanation at the bottom.
        
        // Can be solved two ways. Decide which method to use.
        boolean useAlgebra = true;
        if (useAlgebra) {
            algebraBacktrack(0, algebraTarget / 2);
        } else {
            backtrack(0, 0);
        }
        return totalExpressions;
    }
    
    // This is slow. Algebra is faster.
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
    
    // Explanation at the bottom.
    private void algebraBacktrack(int index, int target) {
        // Base case: if the current target is zero, we reached the original target, so count this path.
        if (index == nums.length) {
            if (target == 0) totalExpressions++;
            return;
        }
        // Exclusion case
        algebraBacktrack(index + 1, target);
        
        // Inclusion case
        algebraBacktrack(index + 1, target - nums[index]);
    }
    
    private int calculateAlgebraTarget() {
        int sum = Arrays.stream(nums).sum();
        return sum + target;        
    }
    
    /*
        Okay, I gotta explain this one. The goal is to add/subtract numbers to reach a target.
        Let S1 = the set of numbers that get ADDED,
        Let S2 = the set of numbers that get SUBTRACTED.
        We know two facts: These two sets, when combined, must reach the target.
                           These two sets, when combined, add up to some arbitrary sum.
        These can be illustrated as:    S1 - S2 = target  (subtract, because S2 values get subtracted)
                                        S1 + S2 = sum     (doesn't matter what the sum is)
        Using algebra, we can combine (add) this system of equations. Notice that S2 would cancel out.
            2(S1) = target + sum
               S1 = (target + sum) / 2
        So we actually don't need to care about the values being subtracted! We can treat this as a
        subset sum problem, only choosing whether to add the current value or skip it. If the current
        subset adds up to (target + sum) / 2, then we can include that path, regardless of how many 
        values are in that subset.
        Consequently, we also know that (target + sum) must an even number, or else division by 2
        would result in a non-integer. It also must be non-negative.
        We can check this right away to see if the problem has a solution.
    */
}