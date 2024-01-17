class Solution {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length()-1;
        
        char[] chars = s.toCharArray();
        
        while (left < right) {
            char leftChar = chars[left];
            char rightChar = chars[right];
            if (isVowel(leftChar) && isVowel(rightChar)) {
                chars[left] = rightChar;
                chars[right] = leftChar;
                left++;
                right--;
            }
            if (!isVowel(leftChar)) left++;
            if (!isVowel(rightChar)) right--;
        }
        return new String(chars);
    }
    
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        if (c == 'a' || c == 'e'
           || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}