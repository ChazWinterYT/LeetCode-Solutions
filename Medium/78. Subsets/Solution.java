class Solution {
    int[] nums;
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;   
        backtrack(0, new ArrayList<>());
        return result;
    }
    
    private void backtrack(int index, List<Integer> current) {
        // Base case: if you reach the end of nums, submit the current sublist
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
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

/*          Old solution (iterative)
        List<List<Integer>> results = new LinkedList<>();
        // Start with an empty List
        results.add(new ArrayList<>());
        
        // For each value in the input, copy all existing Lists from the result list, append
        // the current value to each one, and submit these new Lists to the result List.
        for (int x : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> currentSubset : results) {
                List<Integer> newSubset = new ArrayList<>(currentSubset);
                newSubset.add(x);
                newSubsets.add(newSubset);
            }
            results.addAll(newSubsets);
        }
        return results;
*/