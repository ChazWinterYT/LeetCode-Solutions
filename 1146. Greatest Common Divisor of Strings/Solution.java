class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // Force the first string to be longer so the rest of the code is simpler
        if (str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        }
        if (!str1.startsWith(str2)) return "";
        if (str2.isEmpty()) return str1;
        
        return gcdOfStrings(str1.substring(str2.length()), str2);
    }
}