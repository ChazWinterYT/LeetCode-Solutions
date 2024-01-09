class Solution {
    public String longestCommonPrefix(String[] strs) {
        //edge case, if there's only one string in the array, 
        //return that string
        if (strs.length == 1) return strs[0];
        //iterate through all strings, find the shortest string
        String shortestString = strs[0];
        for (String currentString : strs) {
            if (currentString.length() < shortestString.length()) {
                shortestString = currentString;
            }
        }
        //edge case, if the shortest string was just blank, return ""
        if (shortestString.length() == 0) return "";
        //loop through each charAt location in each string
        for (int i = 0; i < shortestString.length(); i++) {
            //test char is the charAt index i in the first string
            char test = strs[0].charAt(i);
            //check the rest of the strings to see if they have the same char
            //if there is a mismatch, return the substring up to that point
            //if no mismatch, then the outer loop increments and the substring gets longer
            for (String y : strs) {
                if (y.charAt(i) != test) return shortestString.substring(0, i);
            }
        }     
        //if the loop survives, then the entire shortestString is the answer. Return it.
        return shortestString;
    }
}