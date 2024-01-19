class Solution {
    private static final Set<Character> VOWELS = new HashSet<>();
        
    static {
        VOWELS.add('a');
        VOWELS.add('e');
        VOWELS.add('i');
        VOWELS.add('o');
        VOWELS.add('u');
    }
    
    public int maxVowels(String s, int k) {
        int left = 0, right = k - 1;
        int count = 0, maxCount = 0;
        
        for (int i = 0; i < k; i++) {
            char currentChar = s.charAt(i);
            if (VOWELS.contains(currentChar)) count++;
        }
        maxCount = count;
        
        while (right < s.length() - 1) {
            if (VOWELS.contains(s.charAt(left++))) count--;
            if (VOWELS.contains(s.charAt(++right))) count++;
            maxCount = Math.max(count, maxCount);
        }
        
        return maxCount;
    }
}