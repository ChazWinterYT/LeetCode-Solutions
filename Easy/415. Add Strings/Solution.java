class Solution {
    public String addStrings(String num1, String num2) {
        int maxLength = Math.max(num1.length(), num2.length());
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        
        for(int i = 1; i <= maxLength; i++) {
            int sum = carry;
            if (num1.length() - i >= 0) {
                sum += num1.charAt(num1.length() - i) - '0';
            }
            if (num2.length() - i >= 0) {
                sum += num2.charAt(num2.length() - i) - '0';
            }
            carry = sum / 10;
            sum = sum % 10;
            sb.append(sum);
        }
        // If there's still a carry bit left over, append it
        if (carry > 0) {
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }
}