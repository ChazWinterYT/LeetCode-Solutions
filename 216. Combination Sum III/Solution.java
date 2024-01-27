class Solution {
    List<List<Integer>> results = new ArrayList();
    int targetSum;
    int targetNumValues;
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        targetSum = n;
        targetNumValues = k;
        backtrack(1, targetSum, new ArrayList<>());
        return results;
    }
    
    private void backtrack(int start, int targetSum, List<Integer> current) {
        // Base case: If you have reached the target number of values, and the target sum, submit the list.
        if (current.size() == targetNumValues) {
            if (targetSum == 0) {
                results.add(new ArrayList<>(current));
            }
            return;
        }
        
        // Inclusive case: try the next available number (from 1 to 9 inclusive).
        for (int i = start; i <= 9; i++) {
            // if the current value goes over the target, then so will all future values. Break.
            if (i > targetSum) {
                break;
            }
            current.add(i);
            backtrack(i + 1, targetSum - i, current);
            // Backtrack if this number won't work
            current.remove(current.size() - 1);
        }
    }
}