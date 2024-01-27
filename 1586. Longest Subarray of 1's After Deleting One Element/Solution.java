class Solution {
    public int longestSubarray(int[] nums) {
        int numZeros = 0;
        int max = 0;
        
        if (nums[0] == 0) {
            numZeros = 1;
        }
        
        // Two pointers. Expand with the right pointer if 0-1 zeros present.
        // Shrink with left pointer with >1 zeros present. Distance between pointers
        // is the subarray, which we should check for max length.
        int left = 0, right = 0;
        while (right < nums.length) {
            // Expand with the right pointer if we don't have too many zeros. Also count the new value
            // and check the subarray length. Since we must delete one value, right - left is accurate.
            if (numZeros <= 1) {
                max = Math.max(max, right - left);
                right++;
                if (right < nums.length && nums[right] == 0) numZeros++;
            } 
            // Doing the above may have caused the zero count to go over the limit. Check this.
            if (numZeros > 1) {
                // Decrement zero count if the value leaving was a zero.
                if (nums[left++] == 0) numZeros--;
            }
        }
        return max;
    }
}