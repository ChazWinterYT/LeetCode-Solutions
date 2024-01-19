class Solution {
    public int[] sortedSquares(int[] nums) {
        // Determine where in the array is the first non-negative value
        int firstNonNegative = 0;
        while (firstNonNegative < nums.length) {
            if (nums[firstNonNegative] >= 0) break;
            firstNonNegative++;
        }
        /* Starting from the above index, compare to the first negative value.
            Whichever is smaller (absolute value), that's the next one to square.
            Do it until all the numbers are squared. */
        int right = firstNonNegative, left = firstNonNegative - 1;
        int[] result = new int[nums.length];
        int index = 0;
        while (right < nums.length || left >= 0) {
            if (right >= nums.length) { // We're done adding positive (right) values
                result[index++] = nums[left] * nums[left--];
                continue;
            }
            if (left < 0) { // We're done adding negative (left) values
                result[index++] = nums[right] * nums[right++];
                continue;
            }
            // We still have left and right values to process
            if (Math.abs(nums[left]) < nums[right]) {
                result[index++] = nums[left] * nums[left--];
            } else {
                result[index++] = nums[right] * nums[right++];
            }
        }
        return result;
    }
}