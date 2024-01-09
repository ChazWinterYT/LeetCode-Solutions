class Solution {
    List<List<Integer>> combinations = new ArrayList<>();
    List<Integer> currentList = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1);
        return combinations;
    }
    
    private void backtrack(int n, int k, int start) {
        /* If you have k elements in your list, it's a complete combination, so submit it. 
           It needs to be a new list, or else you'll keep mutating the old one. */
        if (currentList.size() == k) {
            combinations.add(new ArrayList<>(currentList));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            currentList.add(i);
            // Move to the next number to be added to the current list
            backtrack(n, k, i + 1);
            /* If we return from the above call, then we had a full list. Remove the last value so we
                can build another combination. */
            currentList.remove(currentList.size() - 1);
            
        }
    }
}