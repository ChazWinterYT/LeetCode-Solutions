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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        // Gotta use Long because Integer.MAX_VALUE is a valid node value
    }
    
    private boolean isValidBST(TreeNode root, long lowerLimit, long upperLimit) {
        if (root == null) return true;
        if (root.val <= lowerLimit || root.val >= upperLimit) return false;
        if (!isValidBST(root.left, lowerLimit, root.val)) return false;
        if (!isValidBST(root.right, root.val, upperLimit)) return false;
        return true;
    }
}