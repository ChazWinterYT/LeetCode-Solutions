class Solution {
    List<List<Integer>> results = new ArrayList<>();
    int[] candidates;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        dfs(0, target, new ArrayList<>());
        return results;
    }
    
    private void dfs(int index, int target, List<Integer> current) {
        if (target == 0) {
            results.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                current.add(candidates[i]);
                dfs(i, target - candidates[i], current);
                // If it fails, remove the last value from the potential list before trying the next one
                current.remove(current.size() - 1);
            }
        }
    }
}