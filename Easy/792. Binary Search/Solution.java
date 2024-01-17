class Solution {
    public int search(int[] nums, int target) {
        //left and right pointers to narrow in on value, and a calculated midpoint
        int left = 0, right = nums.length - 1;
        //check the mid value. if too big, move right to mid
        //if too small, move left to mid (but go past it - you already checked it)
        //do this until left passes right
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                left = mid + 1;
            } else { //nums[mid] > target
                right = mid - 1;
            }
        }
        //if the loop survives, then the value wasn't in the array
        return -1;
    }
}