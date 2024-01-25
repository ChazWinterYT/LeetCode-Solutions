class Solution {
    List<List<String>> results = new ArrayList<>();
    String s;
    
    public List<List<String>> partition(String s) {
        this.s = s;
        backtrack(0, new ArrayList<>());
        return results;
    }
    
    private void backtrack(int start, List<String> current) {
        // Base case: if you reach the end of the string, submit the current list
        if (start == s.length()) {
            results.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            // Try the current substring
            if (isPalindrome(s, start, i)) {
                // Include the current substring if valid
                current.add(s.substring(start, i + 1));
                backtrack(i + 1, current);
                // Backtrack
                current.remove(current.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}