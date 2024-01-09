class Solution {
    int[] baseMap = new int[58];
    int[] testMap = new int[58];
    
    public String minWindow(String s, String t) {
        int left = 0, right = 0;
        for (char c : t.toCharArray()) {
            baseMap[c - 'A']++;
        }
        String shortest = "";
        int shortestLength = Integer.MAX_VALUE;
        
        // Put the first letter of s into the testMap by default
        testMap[s.charAt(0) - 'A'] = 1;
        
        /* When you don't have all the letters, move right and add that new letter
            When you have all the letters, check if it's the shortest substring.
            Then move left and remove that letter to see if you can get a shorter one. */
        while (right < s.length()) {
            char newChar = s.charAt(right);
            char oldChar = s.charAt(left);
            String substring = s.substring(left, right + 1);
            // The testMap now contains all required letters
            if (allCharsPresent(substring)) {
                if (substring.length() < shortestLength) {
                    shortestLength = substring.length();
                    shortest = substring;
                }
                testMap[oldChar - 'A']--;
                left++;
            } else { // The testMap needs more letters
                right++;
                if (right == s.length()) break; // OOB check
                char newNewChar = s.charAt(right);
                testMap[newNewChar - 'A']++;
            }            
            
            // Left could pass right if the shortest substring is a single char
            if (shortest.length() == 1) return shortest;
        }
        
        return shortest;
    }
    
    private boolean allCharsPresent(String substring) {
        for (int i = 0; i < testMap.length; i++) {
            if (testMap[i] < baseMap[i]) {
                return false;
            }
        }
        return true;
    }
}