package PathSumII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Assume the number of the tree nodes is n.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 2ms
 * Rank: 73.43%
 */
public class Solution1 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<Integer> path = new LinkedList<>();

        pathSum(root, sum, path, list, 0);

        return list;
    }

    public void pathSum(TreeNode node, int sum, LinkedList<Integer> path, List<List<Integer>> list, int now) {
        if (node.left == null && node.right == null) {
            // I am leaf
            if (now + node.val == sum) {
                // path sum equals to sum
                path.offerLast(node.val);
                list.add(new LinkedList<Integer>(path));
                // System.out.println(path);
                path.pollLast();
            }
            return;
        }

        // I am not a leaf
        path.offerLast(node.val);

        if (node.left != null) {
            pathSum(node.left, sum, path, list, now + node.val);
        }
        if (node.right != null) {
            pathSum(node.right, sum, path, list, now + node.val);
        }

        path.pollLast();

    }
}
