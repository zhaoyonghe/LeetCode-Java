package A.AllNodesDistanceKInBinaryTree_863;

/**
 * $$ Assume the nodes count of root is n, height is h.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(h)
 */


import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        find(root, target, res, k);
        return res;
    }

    // the returned int means: tell the caller that it should collect nodes distance k from itself.
    // Caller to decide to collect through left or right child path.
    // if -1, do not need to collect.
    private int find(TreeNode root, TreeNode target, List<Integer> res, int k) {
        if (root == null) {
            return -1;
        }
        if (root.val == target.val) {
            collect(root, k, res);
            return k - 1;
        }
        int left = find(root.left, target, res, k);
        if (left == 0) {
            res.add(root.val);
            return -1;
        }
        if (left > 0) {
            collect(root.right, left - 1, res);
            return left - 1;
        }
        int right = find(root.right, target, res, k);
        if (right == 0) {
            res.add(root.val);
            return -1;
        }
        if (right > 0) {
            collect(root.left, right - 1, res);
            return right - 1;
        }
        return -1;
    }

    private void collect(TreeNode node, int dis, List<Integer> res) {
        if (node == null || dis < 0) {
            return;
        }
        if (dis == 0) {
            res.add(node.val);
            return;
        }
        collect(node.left, dis - 1, res);
        collect(node.right, dis - 1, res);
    }
}