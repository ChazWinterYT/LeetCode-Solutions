class Solution {
    public int kthFactor(int n, int k) {
        k--; // 1 is always a factor; don't check it, just start the countdown
        if (k == 0) return 1; // first factor is always 1;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                k--;
            }
            if (k == 0){
                return i;
            } 
        }
        return -1; // if the countdown never completes
    }
}