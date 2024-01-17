class Solution {
    public int missingNumber(int[] nums) {
        int expectedSum = (nums.length)*(nums.length + 1) / 2;
        int actualSum = 0;
        
        for (int x : nums) {
            actualSum += x;
        }
        
        return expectedSum - actualSum;
    }
}