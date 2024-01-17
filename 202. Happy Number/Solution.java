class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = n;

        while(true) {
            int testValue = sum;
            sum = 0;
            while (testValue != 0) {
                int lastDigit = testValue % 10;
                sum += lastDigit * lastDigit;
                testValue = testValue / 10;
            }
            if (sum == 1) return true;
            if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
            }
        }
    }
}