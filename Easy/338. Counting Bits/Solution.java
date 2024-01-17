class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i = 1; i < ans.length; i++) {
            int bitCount = 0;
            int testValue = 1;
            while (i >= testValue) {
                if (i / testValue % 2 == 1) {
                    bitCount++;
                }
                testValue *= 2;
            }
            ans[i] = bitCount;
        }
        return ans;
    }
}

/*
0 bit = special case, don't worry about it
1 bit = odd numbers
2 bit = when num / 2 is odd
4 bit = when num / 4 is odd
8 bit = when num / 8 is odd

    32bit   16bit   8bit    4bit    2bit    1bit
9:  0       0       1       0       0       1
22: 0       1       0       1       1       0
40: 1       0       1       0       0       0
41: 1       0       1       0       0       1
*/