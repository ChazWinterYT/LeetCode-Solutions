/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        
        // Look for the two nodes, p and q
        TreeNode leftAncestor = lowestCommonAncestor(root.left, p, q);
        TreeNode rightAncestor = lowestCommonAncestor(root.right, p, q);
        
        // If we find both nodes on either side of the current root, 
        // then the current root is the common ancestor
        if (leftAncestor != null && rightAncestor != null) return root;
        
        // If one of them is null, then the nodes were on the same side.
        // Return whichever ancestor is not null
        return leftAncestor != null ? leftAncestor : rightAncestor;
    }
}