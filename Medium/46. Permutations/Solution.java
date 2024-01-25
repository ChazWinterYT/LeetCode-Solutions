class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        backtrack(new ArrayList<>());
        return result;
    }
    
    private void backtrack(List<Integer> current) {
        // Base case: if your list has all the numbers, submit it
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // Inclusion case: only run this block if the current number is not already in the sublist
            if (!current.contains(nums[i])) {
                current.add(nums[i]);
                backtrack(current);
                current.remove(current.size() - 1);
            }
        }
    }
}