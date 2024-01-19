class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        long numOperations = 0; 
        /* netChange must be zero at the end. If it is not, then there was an increment that 
           did not have a corresponding decrement. */
        long netChange = 0;
        
        for (int i = 0; i < nums1.length; i++) {
            if (k == 0 && nums1[i] != nums2[i]) {
                return -1; // If k is 0, then this only works if the arrays are already equal.
            } else if (k == 0) {
                continue;
            }
            int diff = nums1[i] - nums2[i];
            if (diff % k != 0) {
                return -1; // Difference in values must be a multiple of k.
            }
            numOperations += Math.abs(diff / k);
            netChange += diff;
        }
        
        /* If netChange is not 0, then the changes don't come in pairs, and the problem has no solution. */
        return (netChange == 0) ? numOperations / 2 : -1;
    }
}