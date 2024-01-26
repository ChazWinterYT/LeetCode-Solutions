class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int value : nums) {
            if (count == 0) {
                candidate = value;
            }
            count += (candidate == value) ? 1 : -1;
        }
        return candidate;
    }

    /*
    O(n) space method. Slow!

    public int majorityElement(int[] nums) {
        //make a HashMap to store the counts of each value in the array
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int majority = nums.length / 2;

        for (int value : nums) {
            if (countMap.containsKey(value)) {
                countMap.put(value, countMap.get(value) + 1);
            } else { //does not contain the key
                countMap.put(value, 1);
            }
            if (countMap.get(value) > majority) return value;
        }
        return -1;
    } 
    */
}