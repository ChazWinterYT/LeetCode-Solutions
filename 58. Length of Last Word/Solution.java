class Solution {
    public int lengthOfLastWord(String s) {
        //start by accounting for the spaces at the end of the string
        int end = s.length()-1;
        while (s.charAt(end) == ' ') {
            end--;
        }
        //now end is the index of the last non-space
        //keep going back until you find another space
        int begin = end;
        while (s.charAt(begin) != ' ') {
            //if you make it to the start of s, then the string is from 0 to end
            //don't forget to add 1: index 0 to 9 is actually 10 chars!
            if (begin == 0) return end + 1;
            begin--;
        }
        //you found the beginning and the end of the last word
        return end - begin;
    }
}