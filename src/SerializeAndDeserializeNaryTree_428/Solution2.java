package SerializeAndDeserializeNaryTree_428;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/**
 * Assume the number of nodes is n.
 * Serialize Time Complexity: O(n)
 * Deserialize Time Complexity: O(n)
 * Serialize Space Complexity: O(n)
 * Deserialize Space Complexity: O(n)
 * Runtime: 6ms
 * Rank: 87.12%
 */

public class Solution2 {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        sHelper(root, sb);
        return sb.toString();
    }

    private void sHelper(Node node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(",").append(node.children.size()).append(",");
        for (Node c : node.children) {
            sHelper(c, sb);
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        Deque<String> q = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return dHelper(q);
    }

    private Node dHelper(Deque<String> q) {
        String s = q.poll();
        if (s.equals("#")) {
            return null;
        }
        int n = Integer.parseInt(q.poll());
        Node node = new Node(Integer.parseInt(s), new ArrayList<Node>());
        while (n > 0) {
            node.children.add(dHelper(q));
            n--;
        }
        return node;
    }
}
