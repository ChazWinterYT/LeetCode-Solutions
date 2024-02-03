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
    Queue<TreeNode> queue = new LinkedList<>();
    
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 1;
        
        root.val = 1;
        queue.add(root);
        
        /* Assign 1 value of 1 to the root. For all left children, assign (2 * parent).
           For all right children, assign (2 * parent + 1).
           Width of this level is (largest value - smallest value + 1). */
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            int minVal = -1;
            int maxVal = -1;
            for (int i = 0; i < queueSize; i++) {
                TreeNode current = queue.poll();
                if (i == 0) minVal = current.val;
                if (i == queueSize - 1) maxVal = current.val;
                
                if (current.left != null) {
                    current.left.val = current.val * 2;
                    queue.add(current.left);
                }
                if (current.right != null) {
                    current.right.val = current.val * 2 + 1;
                    queue.add(current.right);
                }
            }
            maxWidth = Math.max(maxWidth, maxVal - minVal + 1);
        }
        return maxWidth;
    }
}