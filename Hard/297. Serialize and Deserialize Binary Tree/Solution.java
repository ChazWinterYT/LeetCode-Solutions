/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        /* For each node, if it exists, encode its value and add both its children to the queue
            (even if they are null). If it doesn't exist, encode it as a '#'. */
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode != null) {
                sb.append(currentNode.val).append(",");
                queue.offer(currentNode.left);
                queue.offer(currentNode.right);
            } else {
                sb.append("nullNode").append(",");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        
        String[] dataInTree = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dataInTree[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        
        /* For each vaue we check, the next two values in the queue will always be its children 
            (even if they are null). */
        while (!queue.isEmpty() && index < dataInTree.length) {
            TreeNode parent = queue.poll();
            
            // Left child
            if (!dataInTree[index].equals("nullNode")) {
                TreeNode left = new TreeNode(Integer.parseInt(dataInTree[index]));
                parent.left = left;
                queue.offer(left);
            }
            index++;
            
            // Right child
            if (!dataInTree[index].equals("nullNode")) {
                TreeNode right = new TreeNode(Integer.parseInt(dataInTree[index]));
                parent.right = right;
                queue.offer(right);
            }
            index++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));




