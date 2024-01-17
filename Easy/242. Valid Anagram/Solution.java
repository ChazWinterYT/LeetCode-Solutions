class Solution {
    public boolean isAnagram(String s, String t) {
        //the strings must be the same length
        if (s.length() != t.length()) return false;
        //make a HashMap to store chars
        HashMap<Character, Integer> charMap = new HashMap<>();

        //track the count of each char in s
        for (int i = 0; i < s.length(); i++) {
            charMap.put(s.charAt(i), charMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        //decrement the chars in t. if the strings are not anagrams,
        //then at least one element in the map will fall below 0
        for (int i = 0; i < t.length(); i++) {
            charMap.put(t.charAt(i), charMap.getOrDefault(t.charAt(i), 0) - 1);
            if (charMap.get(t.charAt(i)) < 0) return false;
        }
        //if the loop survives, return true
        return true;
    }
}