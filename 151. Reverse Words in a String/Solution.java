class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        System.out.println(Arrays.toString(words));
        
        StringBuilder sb = new StringBuilder();
        String space = "";
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].trim().equals("")) {
                sb.append(space);
                sb.append(words[i]);
                space = " ";
            }   
        }
        return sb.toString();
    }
}