class Solution {
    public boolean isPalindrome(String s) {
        //remove all spaces and punctuation, and set all chars to lowercase
        s = s.replaceAll("[^a-zA-Z0-9]+", "").toLowerCase();
        System.out.println(s);
        //create two pointers to track chars, starting at each end of the String
        int left = 0, right = s.length() - 1;
        //check if the chars are the same while moving the pointers towards each other
        //don't need left = right because that would just be the middle char
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        //if the loop survives, return true
        return true;
    }
}