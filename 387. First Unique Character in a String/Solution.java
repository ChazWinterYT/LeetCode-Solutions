class Solution {
    public int firstUniqChar(String s) {
        int answer = -1;
        int[] charMap = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charMap[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (charMap[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return answer;
    }
}