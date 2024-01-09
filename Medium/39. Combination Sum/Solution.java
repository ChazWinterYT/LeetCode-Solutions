class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), results);
        return results;
    }
    
    private void dfs(int[] candidates, int target, int index, 
                    List<Integer> combination, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<>(combination));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                combination.add(candidates[i]);
                dfs(candidates, target - candidates[i], i, combination, results);
                // If it fails, remove the last value from the potential list before trying the next one
                combination.remove(combination.size() - 1);
            }
        }
    }
}