package SerializeAndDeserializeBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Assume the number of nodes is n.
 * Serialize Time Complexity: O(n)
 * Deserialize Time Complexity: O(n)
 * Serialize Space Complexity: O(n)
 * Deserialize Space Complexity: O(n)
 * Runtime: 32ms
 * Rank: 70.50%
 */
public class Solution2 {
    // Encodes a tree to a single string.
    String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
                sb.append(String.valueOf(node.val)).append(",");
            } else {
                // node == null
                sb.append("N").append(",");
            }
        }

        String result = sb.toString();
        return result.substring(0, result.length() - 1);
    }

    // Decodes your encoded data to tree.
    TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }

        String[] temp = data.split(",");
        TreeNode[] nodes = new TreeNode[temp.length];

        for (int i = 0; i < temp.length; i++) {
            if (!temp[i].equals("N")) {
                nodes[i] = new TreeNode(Integer.valueOf(temp[i]));
            }
        }

        int startOfThisLayer = 0;
        int nodeNumOfThisLayer = 1;

        while (nodeNumOfThisLayer != 0) {
            int startOfNextLayer = startOfThisLayer + nodeNumOfThisLayer;
            int count = 0;

            for (int i = startOfThisLayer; i < startOfNextLayer; i++) {
                if (nodes[i] != null) {
                    int index = startOfNextLayer + count * 2;
                    nodes[i].left = nodes[index];
                    nodes[i].right = nodes[index + 1];
                    count += 1;
                }
            }

            startOfThisLayer = startOfNextLayer;
            nodeNumOfThisLayer = count * 2;
        }

        return nodes[0];
    }
}
