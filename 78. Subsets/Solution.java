class Solution {    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        // Start with an empty List
        results.add(new ArrayList<>());
        
        /* For each value in the input, copy all existing Lists from the result list, append
           the current value to each one, and submit these new Lists to the result List. */
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
    }
}