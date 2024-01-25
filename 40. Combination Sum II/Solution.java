class Solution {
    List<List<Integer>> results = new ArrayList<>();
    int[] candidates;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        Arrays.sort(candidates);
        backtrack(0, target, new ArrayList<>());
        return results;
    }
    
    private void backtrack(int index, int target, List<Integer> current) {
        // Base case: if target == 0, you've reached the sum. Submit the list.
        if (target == 0) {
            results.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            // Don't use values that cause the sum to exceed the target. Since 
            // The array is sorted, that means don't use this one or anything after it.
            if (candidates[i] > target) break;
            
            // Skip duplicates
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            
            // Inclusion case
            current.add(candidates[i]);
            backtrack(i + 1, target - candidates[i], current);
            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}