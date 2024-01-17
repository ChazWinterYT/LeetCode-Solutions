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
        int current = root.val;
        // If both nodes are smaller than current, then the answer is somewhere to the left
        if (p.val < current && q.val < current) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // If both nodes are larger than current, then the answer is somewhere to the right
        if (p.val > current && q.val > current) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // Otherwise, the current node is the common ancestor
        return root;
    }
}