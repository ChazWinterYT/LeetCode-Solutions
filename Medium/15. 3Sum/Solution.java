class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i <  nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int target = 0 - nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left++;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else { //they equal the target
                    answer.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Skip duplicate values
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    //even after you account for duplicates, you still need to
                    //move the pointers to potentially find more triplets
                    left++;
                    right--;
                }
            }
        }
        return answer;
    }
}