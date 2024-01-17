class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for (int x : nums1) {
            map.merge(x, 1, Integer::sum);
        }
        
        for (int y : nums2) {
            if (map.containsKey(y) && map.get(y) > 0) {
                list.add(y);
                map.merge(y, -1, Integer::sum);
            }
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}