class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        
        // Use Floyd's Tortoise and Hare algorithm to detect a cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        int duplicate = nums[0];
        while (slow != duplicate) {
            slow = nums[slow];
            duplicate = nums[duplicate];
        }
        
        return duplicate;
    }
}