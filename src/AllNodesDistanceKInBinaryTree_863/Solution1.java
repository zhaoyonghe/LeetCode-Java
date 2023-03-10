package AllNodesDistanceKInBinaryTree_863;

/**
 * Assume the number of the nodes in root is n.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 13ms
 * Rank: 98.42%
 */


import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    // Important constraints:
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        f(root, target, k, res);
        return res;
    }

    private int f(TreeNode root, TreeNode target, int k, List<Integer> res) {
        if (root == null) {
            return -1;
        }
        if (root == target) {
            collect(target, k, res);
            return k - 1;
        }

        int le = f(root.left, target, k, res);
        int ri = f(root.right, target, k, res);
        if (le < 0 && ri < 0) {
            return -1;
        }
        if (le == 0 || ri == 0) {
            res.add(root.val);
            return -1;
        }
        if (le > 0) {
            collect(root.right, le - 1, res);
            return le - 1;
        }
        // ri > 0
        collect(root.left, ri - 1, res);
        return ri - 1;
    }

    private void collect(TreeNode root, int k, List<Integer> res) {
        if (root == null || k < 0) {
            return;
        }
        if (k == 0) {
            res.add(root.val);
            return;
        }
        collect(root.left, k - 1, res);
        collect(root.right, k - 1, res);
    }
}