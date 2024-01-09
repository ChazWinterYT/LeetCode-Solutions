class Solution {
    public boolean isPalindrome(int x) {  
        if (x < 0) return false;

        int reversed = 0;
        int inputValue = x;

        while (inputValue != 0) {
            int lastDigit = inputValue % 10; 
            reversed = reversed * 10 + lastDigit; 
            inputValue = inputValue / 10; 
        }
        return (x == reversed);
        
        /*
        String xString = Integer.toString(x);
        StringBuilder sb = new StringBuilder(xString);
        sb.reverse();
        return (xString.equals(sb.toString()));
        */
    }
}