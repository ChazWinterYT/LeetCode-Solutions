class Solution {
    public int maxProduct(int[] nums) {
        // 1 <= nums[i] <= 10^3
        int max1 = 0;
        int max2 = 0;

        for (int x : nums) {
            if (x > max1) {
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max2 = x;
            }
        }

        return (max1 - 1) * (max2 - 1);
    }
}