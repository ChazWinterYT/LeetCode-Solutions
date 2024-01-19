class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue(k+1, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int distA = a[0]*a[0] + a[1]*a[1];
                int distB = b[0]*b[0] + b[1]*b[1];
                return Integer.compare(distB, distA);
            }
        });
        
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Eject the farthest point from the Queue
            }
        }
        
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
}