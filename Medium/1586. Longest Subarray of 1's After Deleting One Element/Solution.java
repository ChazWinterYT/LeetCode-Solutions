class Solution {
    public int longestSubarray(int[] nums) {
        int numZeros = 0;
        int max = 0;
        
        // Two pointers. Expand with the right pointer if 0-1 zeros present.
        // Shrink with left pointer if >1 zeros present. Distance between pointers
        // is the subarray, which we should check for max length.
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                numZeros++;
            }
            // Doing the above may have caused the zero count to go over the limit. Fix this.
            while (numZeros > 1) {
                if (nums[left++] == 0) {
                    numZeros--;
                }
            }
            // You should have a valid subarray at this point. Check its length.
            // Since we are required to delete one element, (right - left) is accurate.
            max = Math.max(max, right - left);
        }
        
        
        return max;
    }
}