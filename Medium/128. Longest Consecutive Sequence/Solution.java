class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        int longestStreak = 0;
        
        for (int x : nums) {
            // Don't check a number if would be in the middle of a sequence.
            if (set.contains(x - 1)) continue;
            
            int currentStreak = 1;
            int currentNum = x;
            
            while (set.contains(currentNum + 1)) {
                currentStreak++;
                currentNum++;
            }
            longestStreak = Math.max(longestStreak, currentStreak);
        }
        return longestStreak;
    }
}