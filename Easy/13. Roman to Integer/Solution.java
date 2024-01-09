class Solution {
    public int romanToInt(String s) {
        int result = 0;
        char romanChar = '@';
        char[] theChars = s.toCharArray();

        for (int i = 0; i < theChars.length; i++) {
            romanChar = theChars[i];
            switch (romanChar) {
                case 'I' : result += 1; break;
                case 'V' : result += 5; break;
                case 'X' : result += 10; break;
                case 'L' : result += 50; break;
                case 'C' : result += 100; break;
                case 'D' : result += 500; break;
                case 'M' : result += 1000; break;
            }
            if (i == 0) continue;
            if (romanChar == 'V' || romanChar == 'X') {
                if (theChars[i - 1] == 'I') {
                    result -= 2;
                }
            }
            if (romanChar == 'L' || romanChar == 'C') {
                if (theChars[i-1] == 'X') {
                    result -= 20;
                }
            }
            if (romanChar == 'D' || romanChar == 'M') {
                if (theChars[i-1] == 'C') {
                    result -= 200;
                }
            }
        }
        return result;
    }
}