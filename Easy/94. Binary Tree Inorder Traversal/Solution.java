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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        //create a node to keep track of our current place in the tree
        TreeNode current = root;
        //traverse the tree
        while (current != null || !stack.isEmpty()) {
            //keep going left in the tree. If there is a node, put it on the stack
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            //if you can't go left anymore, pop the top of the stack and put it on the list
            //then go right. do this until the stack is empty
            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }
        return list;
    }
}