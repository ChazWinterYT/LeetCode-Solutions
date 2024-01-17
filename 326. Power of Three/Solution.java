class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        if (n == 1) return true;
        while (n % 3 == 0) {
            if (n == 3) return true;
            n /= 3;
        }
        return false;
    }
}