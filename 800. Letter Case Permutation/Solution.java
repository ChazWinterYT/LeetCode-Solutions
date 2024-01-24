class Solution {
    private List<String> result = new ArrayList<>();
    String s;
    
    public List<String> letterCasePermutation(String s) {
        this.s = s;
        backtrack(s.toCharArray(), 0);
        return result;
    }
    
    private void backtrack(char[] chars, int index) {
        // Submit a result when the String is complete
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }
        
        // Skip the current char
        backtrack(chars, index + 1);
        
        // Utilize the current char if it's a letter
        if (Character.isLetter(chars[index])) {
            // Flip its case (could use ^= (1 << 5) bit manip, but I don't wanna)
            flipCase(chars, index);
            backtrack(chars, index + 1);
            // Backtrack to previous state (flip the case back)
            flipCase(chars, index);
        }
    }
    
    private void flipCase(char[] chars, int index) {
        if (Character.isLowerCase(chars[index])) {
            chars[index] = Character.toUpperCase(chars[index]);
        } else { // it was upper case already
            chars[index] = Character.toLowerCase(chars[index]);
        }
    }
}