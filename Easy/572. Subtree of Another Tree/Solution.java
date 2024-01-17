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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        
        if (root.val == subRoot.val) {
            if (sameTree(root, subRoot)) {
                return true;
            }
        }
        return isSubtree(root.left, subRoot)
            || isSubtree(root.right, subRoot);
    }
    
    private boolean sameTree(TreeNode first, TreeNode second) {
        if (first == null && second == null) return true;
        if (first == null || second == null) return false;
        if (first.val != second.val) return false;
        return sameTree(first.left, second.left)
            && sameTree(first.right, second.right);
    }
}