class Solution {
    public int maxSum(int[] nums) {
        int result = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (sameMaxDigit(nums[i], nums[j])) {
                    result = Math.max(result, nums[i] + nums[j]);
                }
            }
        }
        return result;
    }
    
    private boolean sameMaxDigit(int a, int b) {
        int maxA = 0, maxB = 0;
        while (a > 0) {
            maxA = Math.max(maxA, a % 10);
            a = a / 10;
        }
        while (b > 0) {
            maxB = Math.max(maxB, b % 10);
            b = b / 10;
        }
        return maxA == maxB;
    }
}