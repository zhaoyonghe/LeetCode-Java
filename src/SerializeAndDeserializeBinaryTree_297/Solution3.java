package SerializeAndDeserializeBinaryTree_297;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * $$ Assume the number of nodes is n.
 * $$ Serialize Time Complexity: O(n)
 * $$ Deserialize Time Complexity: O(n)
 * $$ Serialize Space Complexity: O(n)
 * $$ Deserialize Space Complexity: O(n)
 */

public class Solution3 {
    private final TreeNode nullNode = new TreeNode(0);

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == this.nullNode) {
                sb.append("n;");
                continue;
            }
            sb.append(node.val).append(";");
            q.offer(node.left == null ? this.nullNode : node.left);
            q.offer(node.right == null ? this.nullNode : node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) {
            return null;
        }
        String[] fields = data.split(";");
        Deque<TreeNode> q = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(fields[0]));
        q.offer(root);
        int i = 1;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (fields[i].equals("n")) {
                node.left = null;
            } else {
                node.left = new TreeNode(Integer.parseInt(fields[i]));
                q.offer(node.left);
            }
            if (fields[i + 1].equals("n")) {
                node.right = null;
            } else {
                node.right = new TreeNode(Integer.parseInt(fields[i + 1]));
                q.offer(node.right);
            }
            i += 2;
        }
        return root;
    }
}