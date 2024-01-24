class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        /* For each number, mark its corresponding index with a negative number. 
           If you enounter that value again, its index will already be negative, so it is
           part of the solution. */
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // Gotta convert to 0-indexing
            if (nums[index] < 0) {
                result.add(index + 1);   // Convert back to 1-indexing
            }
            nums[index] *= -1;
        }
        return result;
    }
}