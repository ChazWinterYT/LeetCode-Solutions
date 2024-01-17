class Solution {
    public int longestPalindrome(String s) {
        int result = 0;
        // Store all the letters in an array
        int[] chars = new int[58];
        for (char c : s.toCharArray()) {
            chars[c - 'A']++;
        }

        // Even values will always work. Add them to the result.
        // For the odds, remove one letter and count the rest, then add a 
        // single odd letter back in at the end (because one can go in the middle)
        boolean arrayHasOddValue = false;
        for (int x : chars) {
            if (x % 2 == 0) { // x is even
                result += x;
            } else { // x is odd
                result += x - 1;
                arrayHasOddValue = true;
            }
        }
        if (arrayHasOddValue) result++;
        return result;
    }
}