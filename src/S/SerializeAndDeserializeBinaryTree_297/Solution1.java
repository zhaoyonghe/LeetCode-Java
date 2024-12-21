package S.SerializeAndDeserializeBinaryTree_297;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * $$ Assume the number of nodes is n.
 * $$ Serialize Time Complexity: O(n)
 * $$ Deserialize Time Complexity: O(n)
 * $$ Serialize Space Complexity: O(n)
 * $$ Deserialize Space Complexity: O(n)
 */

public class Solution1 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String sb = root.val +
                "," + serialize(root.left) +
                "," + serialize(root.right);
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> q = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return dHelper(q);
    }

    private TreeNode dHelper(Deque<String> q) {
        String s = q.poll();
        if (s.equals("#")) {
            return null;
        }
        // Use Integer.parseInt but not Integer.valueOf, since the latter results in redundant unboxing.
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = dHelper(q);
        node.right = dHelper(q);
        return node;
    }
}
