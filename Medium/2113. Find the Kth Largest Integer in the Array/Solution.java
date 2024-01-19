import java.math.BigInteger;
import java.util.PriorityQueue;

public class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<BigInteger> minHeap = new PriorityQueue<>();
        
        for (String x : nums) {
            minHeap.add(new BigInteger(x));
            
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        return minHeap.poll().toString();
    }
}
