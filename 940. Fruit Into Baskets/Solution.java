class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int maxFruits = 0;
        
        while (end < fruits.length) {
            map.merge(fruits[end++], 1, Integer::sum);
            while (map.size() > 2) {
                map.merge(fruits[start], -1, Integer::sum);
                if (map.get(fruits[start]) == 0) {
                    map.remove(fruits[start]);
                }
                start++;
            }
            maxFruits = Math.max(maxFruits, end - start);
            // We incremented end, so this subtraction is correct!
        }
        return maxFruits;
    }
}