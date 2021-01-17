package PopulatingNextRightPointersInEachNodeII;

import java.util.ArrayList;
import java.util.List;

/**
 * Assume n is the number of nodes in root.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 4ms
 * Rank: 83.22%
 */
public class Solution1 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        List<List<Node>> list = new ArrayList<>();
        levelOrderTraversal(root, 0, list);
        return root;
    }

    public void levelOrderTraversal(Node root, int layer, List<List<Node>> list) {
        if (layer > list.size() - 1) {
            list.add(new ArrayList<Node>());
        }
        int n = list.get(layer).size();
        if (n > 0) {
            list.get(layer).get(n - 1).next = root;
        }
        list.get(layer).add(root);
        if (root.left != null) {
            levelOrderTraversal(root.left, layer + 1, list);
        }
        if (root.right != null) {
            levelOrderTraversal(root.right, layer + 1, list);
        }
    }
}
