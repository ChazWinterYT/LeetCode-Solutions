class Solution {
    public int myAtoi(String s) {
        if (s.length() == 0) return 0;
        int index = 0;
        boolean isPositive = true;
        
        // Handle leading whitespace
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index >= s.length()) return 0;
        // Handle positive and negative
        if (s.charAt(index) == '+') {
            index++;    // isPositive flag is already true
        } else if (s.charAt(index) == '-') {
            isPositive = false;
            index++;
        }
        if (index >= s.length()) return 0;
        // Handle string not a digit
        if (!Character.isDigit(s.charAt(index))) return 0;
        // Handle digits
        String digitsAsString = handleDigits(s.substring(index));
        if (digitsAsString.equals("")) return 0;
        // Handle values out of range
        if (!isValidInt(digitsAsString, isPositive)) {
            return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        // Integer.MIN_VALUE will not parse. Handle it on its own.
        if (digitsAsString.equals("2147483648")) return Integer.MIN_VALUE;
        int result = Integer.parseInt(digitsAsString);
        return isPositive ? result : -result;
    }
    
    private String handleDigits(String s) {
        // Handle leading zeroes
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < s.length() && s.charAt(index) == '0') {
            index++;
        }
        // Handle the rest
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            sb.append(s.charAt(index));
            if (sb.length() == 11) {
                break;
            }
            index++;
        }
        return sb.toString();
    }
    
    private boolean isValidInt(String s, boolean isPositive) {
        // We only need to do this for 10 digit numbers
        if (s.length() < 10) return true;
        if (s.length() > 10) return false;
        // check the first 9 chars against max int / 10
        int first9digits = Integer.parseInt(s.substring(0,9));
        if (first9digits > Integer.MAX_VALUE / 10) return false;
        // Now make sure the 10th digit will fit, if we're close
        // It can't be a 9 ever, and can't be an 8 if the number is positive
        if (first9digits == Integer.MAX_VALUE / 10) {
            if (s.charAt(9) == '9') return false;
            if (isPositive && s.charAt(9) == '8') return false;
        }
        return true;
    }
}