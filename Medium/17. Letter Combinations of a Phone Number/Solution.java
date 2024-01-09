class Solution {
    String[] lettersFromDigit = new String[] {"", "", "abc", "def", 
                                "ghi", "jkl", "mno",
                                "pqrs", "tuv", "wxyz"};
    List<String> results = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return results;
        dfs(digits, 0, new StringBuilder());
        return results;
    }
    
    private void dfs(String digits, int index, StringBuilder word) {
        if (word.length() == digits.length()) {
            results.add(word.toString());
            return;
        }
        String currentLetters = lettersFromDigit[digits.charAt(index) - '0'];
        for (char letter : currentLetters.toCharArray()) {
            word.append(letter);
            dfs(digits, index + 1, word);
            // Go back one letter and keep searching when done with a word
            word.deleteCharAt(word.length() - 1);
        }
    }
}