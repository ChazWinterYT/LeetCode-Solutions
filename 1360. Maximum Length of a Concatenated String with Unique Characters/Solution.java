class Solution {
    private int maxLength = 0;
    private List<String> arr;
    
    public int maxLength(List<String> arr) {
        this.arr = arr;
        backtrack(0, new StringBuilder());
        return maxLength;
    }
    
    private void backtrack(int index, StringBuilder currentWord) {
        if (index == arr.size()) {
            maxLength = Math.max(currentWord.length(), maxLength);
            return;
        }
        
        // Skip current String
        backtrack(index + 1, currentWord);
        
        // Include current String if characters are still unique
        String candidate = arr.get(index);
        if (uniqueChars(candidate, currentWord.toString())) {
            currentWord.append(candidate);
            backtrack(index + 1, currentWord);
            // Backtrack to previous state
            currentWord.setLength(currentWord.length() - candidate.length());
        }
    }
    
    /* Helper method to determine if two Strings have unique chars */
    private boolean uniqueChars(String word1, String word2) {
        Set<Character> set = new HashSet<>();
        for (char c : word1.toCharArray()) {
            if (!set.add(c)) return false;
        }
        for (char c : word2.toCharArray()) {
            if (!set.add(c)) return false;
        }
        return true; // if both loops survive, then all chars were unique
    }
}