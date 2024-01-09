class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            /* Determine which half of the array is the correctly sorted half
                Then determine if the target is in the sorted half (proceed normally),
                or the unsorted half (discard the sorted half) */
            if (nums[left] <= nums[mid]) { // Left half is sorted
                if (target >= nums[left] && target < nums[mid]) { // Target is in sorted half
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // Right half is sorted
                if (target > nums[mid] && target <= nums[right]) { // Target is in sorted half
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}