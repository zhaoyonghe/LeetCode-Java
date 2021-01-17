package SerializeAndDeserializeBinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Assume the number of nodes is n.
 * Serialize Time Complexity: O(n)
 * Deserialize Time Complexity: O(n)
 * Serialize Space Complexity: O(logn)
 * Deserialize Space Complexity: O(logn)
 * Runtime: 23ms
 * Rank: 83.87%
 */

public class Solution3 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public void serialize(TreeNode root, StringBuilder sb) {
        // collect nodes in pre-order traversal
        if (root == null) {
            sb.append("N,");
        } else {
            sb.append(String.valueOf(root.val)).append(",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return deserialize(queue);
    }

    public TreeNode deserialize(Queue<String> queue) {
        // retrieve nodes in pre-order traversal
        String s = queue.poll();
        if (s.equals("N")) {
            return null;
        } else {
            int val = Integer.valueOf(s);
            TreeNode node = new TreeNode(val);
            node.left = deserialize(queue);
            node.right = deserialize(queue);
            return node;
        }
    }
}