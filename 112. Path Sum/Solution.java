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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
    /*      Old solution, no recursion :(
        public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        //two stacks, one to track the nodes and one to track the sum as we move through the nodes
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sum = new Stack<>();
        //node used to traverse the tree, and int to keep track of the current sum
        TreeNode current = root;
        int currentSum = 0;
        //start by pushing the root node and its value to their respective stacks
        stack.push(current);
        sum.push(current.val);
        while (!stack.isEmpty()) {
            current = stack.pop();
            currentSum = sum.pop();
            //if left and right nodes are both null, this is a leaf. check the current sum.
            if (current.left == null && current.right == null) {
                if (currentSum == targetSum) return true;
            } 
            //if there is a left node, add its value to the current sum and push it to the stack
            //same for right node
            if (current.left != null) {
                stack.push(current.left);
                sum.push(currentSum + current.left.val);
            }
            if (current.right != null) {
                stack.push(current.right);
                sum.push(currentSum + current.right.val);
            }
        }
        return false;
    }
    */
}