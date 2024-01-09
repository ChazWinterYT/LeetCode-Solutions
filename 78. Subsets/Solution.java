class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        int n = nums.length;
        
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> combination = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    combination.add(nums[j]);
                }
            }
            results.add(combination);
        }
        return results;
    }
}