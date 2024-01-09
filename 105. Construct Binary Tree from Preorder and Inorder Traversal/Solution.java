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
    int preIndex = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) return null;
        
        TreeNode node = new TreeNode(preorder[preIndex++]);
        if (start == end) return node;
        
        int inOrderIndex = findIndex(inorder, start, end, node.val);
        node.left = buildTree(preorder, inorder, start, inOrderIndex - 1);
        node.right = buildTree(preorder, inorder, inOrderIndex + 1, end);
        
        return node;
    }
    
    private int findIndex (int[] inorder, int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == value) return i;
        }
        throw new IllegalArgumentException("Value not in array.");
    }
}