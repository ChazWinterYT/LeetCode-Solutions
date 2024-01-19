class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Set<Integer> freqSet = new HashSet<>();
        
        for (int x : arr) {
            freqMap.merge(x, 1, Integer::sum);
        }
        for (int y : freqMap.values()) {
            if (freqSet.contains(y)) return false;
            freqSet.add(y);
        }
        
        return true;
    }
}