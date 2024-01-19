import java.math.BigInteger;

class Solution {
    public String removeDigit(String number, char digit) {
        String result = "";
        BigInteger resultAsInt = BigInteger.ZERO;
        char[] chars = number.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == digit) {
                String testVal = removeDigit(chars, i);
                BigInteger testInt = new BigInteger(testVal);
                if (testInt.compareTo(resultAsInt) > 0) {
                    resultAsInt = testInt;
                    result = testVal;
                }
            }
        }
        
        return result;
    }
    
    private String removeDigit(char[] chars, int index) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (i == index) continue;
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}