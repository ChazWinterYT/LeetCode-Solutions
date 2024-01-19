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
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }
    
    private int goodNodes(TreeNode root, int maxSoFar) {
        if (root == null) return 0;
        
        int count = 0;
        
        if (root.val >= maxSoFar) {
            count++;
            maxSoFar = root.val;
        }
        
        count += goodNodes(root.left, maxSoFar);
        count += goodNodes(root.right, maxSoFar);
        
        return count;
    }
}