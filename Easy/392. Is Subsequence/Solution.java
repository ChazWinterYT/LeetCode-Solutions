class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() == 0) return false;
        int sPointer = 0;
        int tPointer = 0;
        
        while (tPointer < t.length()) {
            char sChar = s.charAt(sPointer);
            char tChar = t.charAt(tPointer);
            if (sChar == tChar) {
                sPointer++;
            }
            if (sPointer == s.length()) return true;
            tPointer++;
        }
        return false;
    }
}