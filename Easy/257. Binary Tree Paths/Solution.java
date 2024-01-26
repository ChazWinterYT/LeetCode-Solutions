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
    List<String> result = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, new ArrayList<>());
        return result;
    }
    
    private void dfs(TreeNode node, List<String> current) {
        current.add(String.valueOf(node.val));
        
        if (node.left == null && node.right == null) {
            result.add(generatePath(current));
            return;
        }
        
        if (node.left != null) {
            dfs(node.left, current);
            // Backtrack
            current.remove(current.size() - 1);
        }
        
        if (node.right != null) {
            dfs(node.right, current);
            // Backtrack 
            current.remove(current.size() - 1);
        }
    }
    
    private String generatePath(List<String> list) {
        StringBuilder sb = new StringBuilder();
        String arrow = "";
        for (String s : list) {
            sb.append(arrow);
            arrow = "->";
            sb.append(s);
        }
        return sb.toString();
    }
}