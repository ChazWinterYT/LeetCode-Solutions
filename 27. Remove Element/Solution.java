class Solution {
    public int removeElement(int[] nums, int val) {
        int leftPointer = 0, rightPointer = 0;
        while (rightPointer < nums.length) {
            if (nums[rightPointer] == val) {
                rightPointer++;
            } else {
                nums[leftPointer] = nums[rightPointer];
                leftPointer++;
                rightPointer++;
            }
        }
        return leftPointer;
    }
}