class Solution {
    public int lengthOfLongestSubstring(String s) {
        //edge case where the string is length 0
        if (s == null || s.length() == 0) return 0;
             
        int left = 0, right = 0;
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                maxLength = Math.max(maxLength, right - left);
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }
}