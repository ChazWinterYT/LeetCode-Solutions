class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        
        // Store all char counts from word1 into map1
        for (int i = 0; i < word1.length(); i++) {
            char currentChar = word1.charAt(i);
            map1.put(currentChar, map1.getOrDefault(currentChar, 0) + 1);
        }
        
        // Store all char counts from word2 into map2
        for (int i = 0; i < word2.length(); i++) {
            char currentChar = word2.charAt(i);
            map2.put(currentChar, map2.getOrDefault(currentChar, 0) + 1);
        }
        
        // Check if the maps have the same keyset (same chars in both words)
        if (!map1.keySet().equals(map2.keySet())) return false;
        
        // Check if the frequency counts of both words match
        List<Integer> list1 = new ArrayList<>(map1.values());
        List<Integer> list2 = new ArrayList<>(map2.values());
        Collections.sort(list1);
        Collections.sort(list2);
        
        return list1.equals(list2);
    }
}