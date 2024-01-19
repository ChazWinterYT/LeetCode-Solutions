class Solution {
    public int minimumAverageDifference(int[] nums) {
        int answer = 0;
        int difference = 0;
        int smallestSoFar = Integer.MAX_VALUE;
        long subtotalA = 0;
        long averageA = 0;
        long subtotalB = 0;
        long averageB = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            subtotalA += nums[i];
            averageA = subtotalA / (i + 1);
            subtotalB = sum - subtotalA;
            if (i + 1 < nums.length) {
                averageB = subtotalB / (nums.length - i - 1);
            }   else {
                averageB = 0;
            }
            difference = Math.abs((int)averageA - (int)averageB);
            if (difference < smallestSoFar) {
                smallestSoFar = difference;
                answer = i;
            }
            if (smallestSoFar == 0) {
                return answer;
            }
        }
        return answer;
    }
}