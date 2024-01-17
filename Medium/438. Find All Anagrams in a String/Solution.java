class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        // If p is longer than s, then no anagrams will exist
        if (p.length() > s.length()) return result;
        
        // Populate the baseMap
        HashMap<Character, Integer> baseMap = new HashMap<>();
        HashMap<Character, Integer> testMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            baseMap.merge(c, 1, Integer::sum);
        }
        
        int start = 0, end = 0;
        
        while (end < s.length()) {
            char oldChar = s.charAt(start);
            char newChar = s.charAt(end);
            if (baseMap.get(newChar) == null) {
                testMap = new HashMap<>();
                start = end + 1;
                end  = start;
                continue;
            }
            testMap.merge(newChar, 1, Integer::sum);
            // When the subLength is too small, keep adding letters
            // when it's right, check the maps for equality
            // then remove the old char and add the new one (plus one)
            int subLength = end - start + 1;
            if (subLength == p.length()) {
                if (baseMap.equals(testMap)) {
                    result.add(start);
                }
                testMap.merge(oldChar, -1, Integer::sum);
                if (testMap.get(oldChar) == 0) {
                    testMap.remove(oldChar);
                }
                start++;
            }
            end++;
        }
        
        return result;
    }
}