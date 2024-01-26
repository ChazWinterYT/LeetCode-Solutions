/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Queue<TreeNode> queue;
    
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        int children = 1;
        
        queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int childrenNextLevel = 0;
            double sum = 0.0;
            for (int i = 0; i < children; i++) {
                TreeNode node = queue.poll();
                childrenNextLevel += getChildrenThisNode(node);
                sum += node.val;
            }
            result.add(sum / children);
            children = childrenNextLevel;
        }
        return result;
    }
    
    private int getChildrenThisNode(TreeNode node) {
        int count = 0;
        if (node.left != null) {
            queue.offer(node.left);
            count++;
        }
        if (node.right != null) {
            queue.offer(node.right);
            count++;
        }
        return count;
    }
}