class Solution {
    Set<List<Integer>> resultsSet = new HashSet<>();
    int[] nums;
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        Arrays.sort(this.nums);
        List<List<Integer>> results = new ArrayList<>();
        backtrack(0, new ArrayList<>());
        
        for (List<Integer> list : resultsSet) {
            results.add(list);
        }
        return results;
    }
    
    private void backtrack(int index, List<Integer> current) {
        // Base case: if you reach the end of the input array, submit the current list
        if (index == nums.length) {
            resultsSet.add(new ArrayList<>(current));
            return;
        }
        
        // Inclusion case
        current.add(nums[index]);
        backtrack(index + 1, current);
        
        // Exclusion case
        current.remove(current.size() - 1);
        backtrack(index + 1, current);
    }
}