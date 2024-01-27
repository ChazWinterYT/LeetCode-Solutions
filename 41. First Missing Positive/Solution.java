class Solution {
    public int firstMissingPositive(int[] nums) {
        // This is a number that can be used to mark non-positive numbers. It is not possible for this
        // number to be the solution to the problem since it's greater than the length of nums.
        final int NEG_MARKER = 100_000;
        
        // Go through the array and filter the negative and zero values.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = NEG_MARKER;
            }
        }
        
        // Iterate through the array again. For each value, if (value - 1) is in bounds, mark
        // that index of the array negative. If it's out of bounds, it can't be the solution anyway.
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (index < nums.length) {
                nums[index] = -Math.abs(nums[index]); 
                // It might already be negative if the array contains duplicates. This handles it.
            }
        }
        
        // Finally, the index (plus 1) of the first positive value in the array is the 
        // smallest missing positive.
        // If none of the values are positive, then nums.length (plus 1) is the solution.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}