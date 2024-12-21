package M.MaximumWidthOfBinaryTree_662;

import java.util.ArrayList;
import java.util.List;

/**
 * Assume n is the number of nodes in the tree root.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 5ms
 * Rank: 11.80%
 */
public class Solution1 {
    public int widthOfBinaryTree(TreeNode root) {
        List<Long[]> list = new ArrayList<>();
        fill(root, 0, 0, list);
        return list.stream().mapToInt(a -> (int) (a[1] - a[0] + 1)).max().getAsInt();
    }

    private void fill(TreeNode node, long num, int level, List<Long[]> list) {
        if (node == null) {
            return;
        }
        if (list.size() == level) {
            list.add(new Long[2]);
        }
        Long[] minmax = list.get(level);
        minmax[0] = minmax[0] == null ? num : Math.min(num, minmax[0]);
        minmax[1] = minmax[1] == null ? num : Math.max(num, minmax[1]);
        fill(node.left, num * 2, level + 1, list);
        fill(node.right, num * 2 + 1, level + 1, list);
    }
}