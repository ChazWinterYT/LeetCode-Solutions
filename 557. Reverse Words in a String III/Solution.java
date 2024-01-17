class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        
        String space = "";
        for (int i = 0; i < words.length; i++) {
            sb.append(space);
            sb.append(new StringBuilder(words[i]).reverse().toString());
            space = " ";
        }
        return sb.toString();
    }
}