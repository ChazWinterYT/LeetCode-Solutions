class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int max3 = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            // check if the current element can be the '1'
            if (nums[i] < max3) return true;
            
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                max3 = stack.pop();
            }
            
            stack.push(nums[i]);
            
        }
        // if the loop survives, then no such pattern exists
        return false;
    }
}