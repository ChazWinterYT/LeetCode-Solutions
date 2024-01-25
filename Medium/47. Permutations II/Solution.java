class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    boolean[] used;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        Arrays.sort(this.nums);
        this.used = new boolean[nums.length];
        
        backtrack(new ArrayList<>());
        return result;
    }
    
    private void backtrack(List<Integer> current) {
        // Base case: if you have all the numbers, submit the sublist
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // Inclusion case: Only add the current element if that exact element hasn't been used yet,
            // AND (it's different from the previous element, OR
            // they're the same, but the previous element has been used)
            if (!used[i]
               && (i == 0 || nums[i] != nums[i - 1] || used[i - 1])) {
                current.add(nums[i]);
                used[i] = true;
                backtrack(current);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }
}