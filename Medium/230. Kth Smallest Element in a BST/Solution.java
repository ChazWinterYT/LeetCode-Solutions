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
    public int kthSmallest(TreeNode root, int k) {
        return kthSmallest(root, k, new int[]{0}); // Using an array so the int value becomes mutable
    }
    
    private int kthSmallest(TreeNode node, int k, int[] count) {
        if (node == null) return -1;
        
        int left = kthSmallest(node.left, k, count);
        if (left != -1) return left;
        
        count[0]++;
        if (count[0] == k) return node.val;
        
        return kthSmallest(node.right, k, count);
    }
}