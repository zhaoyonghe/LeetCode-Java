package PopulatingNextRightPointersInEachNodeI_116;

import java.util.ArrayList;
import java.util.List;

/**
 * Assume n is the number of nodes in root.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Solution1 {
    public Node connect(Node root) {
        List<List<Node>> all = new ArrayList<>();
        levelOrder(root, all, 0);
        for (List<Node> levelNodes : all) {
            for (int i = 1; i < levelNodes.size(); i++) {
                levelNodes.get(i - 1).next = levelNodes.get(i);
            }
        }
        return root;
    }

    private void levelOrder(Node node, List<List<Node>> all, int level) {
        if (node == null) {
            return;
        }
        if (all.size() == level) {
            all.add(new ArrayList<>());
        }
        all.get(level).add(node);
        levelOrder(node.left, all, level + 1);
        levelOrder(node.right, all, level + 1);
    }
}
