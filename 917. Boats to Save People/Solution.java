class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int numTrips = 0;

        while (left <= right) {
            int tripWeight = people[right];
            if (left == right) {
                numTrips++;
                break;
            }
            if (people[left] + people[right] <= limit) {
                right--;
                left++;
            } else {
                right--;
            }
            numTrips++;
        }

        return numTrips;
    }
}