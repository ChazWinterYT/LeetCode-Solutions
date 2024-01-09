class Solution {
    public int reverse(int x) {       
        // flag to remember if x was initially negative
        boolean negative = x < 0;
        x = Math.abs(x);
        int result = 0;
        while (x > 0) {
            if (result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            result = result * 10 + digit;
            x = x / 10;
        }
        return negative ? -result : result;
    }
}