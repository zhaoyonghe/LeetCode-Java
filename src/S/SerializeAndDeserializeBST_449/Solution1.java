package S.SerializeAndDeserializeBST_449;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Assume the number of nodes is n.
 * Serialize Time Complexity: O(n)
 * Deserialize Time Complexity: O(n)
 * Serialize Space Complexity: O(n)
 * Deserialize Space Complexity: O(n)
 * Runtime: 4ms
 * Rank: 93.16%
 */

public class Solution1 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sHelper(root, sb);
        return sb.toString();
    }

    private void sHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.val).append(",");
        sHelper(node.left, sb);
        sHelper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        Deque<String> q = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return dHelper(q, -1, 10001);
    }

    private TreeNode dHelper(Deque<String> q, int lower, int upper) {
        if (q.peek() == null) {
            return null;
        }
        int v = Integer.parseInt(q.peek());
        if (lower > v || v > upper) {
            return null;
        }
        q.poll();
        TreeNode node = new TreeNode(v);
        node.left = dHelper(q, lower, v);
        node.right = dHelper(q, v, upper);
        return node;
    }
}
