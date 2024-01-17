class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        
        int runningProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            answer[i] = runningProduct;
            runningProduct *= nums[i];
        }
        
        runningProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= runningProduct;
            runningProduct *= nums[i];
        }

        return answer;
    }
}