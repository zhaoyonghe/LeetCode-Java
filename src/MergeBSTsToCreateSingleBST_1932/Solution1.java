package MergeBSTsToCreateSingleBST_1932;

import java.util.*;

/**
 * Assume n is trees.length.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 42ms
 * Rank: 89.24%
 */

public class Solution1 {
    // Important constraints:
    public TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer, TreeNode> leaves = new HashMap<>();
        Map<Integer, TreeNode> roots = new HashMap<>();

        for (TreeNode root : trees) {
            // The number of nodes in each tree is in the range [1, 3].
            // Each node in the input may have children but no grandchildren.
            // So I do not need to run a recursive function to fill leaves.
            if (root.left != null) {
                if (leaves.containsKey(root.left.val)) {
                    return null;
                }
                leaves.put(root.left.val, root.left);
            }
            if (root.right != null) {
                if (leaves.containsKey(root.right.val)) {
                    return null;
                }
                leaves.put(root.right.val, root.right);
            }
        }

        // top should be the root of the merged BST.
        TreeNode top = null;
        for (TreeNode root : trees) {
            if (!leaves.containsKey(root.val)) {
                if (top != null) {
                    // More than one root cannot attach to any leaf.
                    return null;
                }
                top = root;
                continue;
            }
            roots.put(root.val, root);
        }
        if (top == null) {
            // Cannot find the merged BST root.
            return null;
        }

        Deque<TreeNode> q = new ArrayDeque<>();
        if (top.left != null) {
            q.offer(top.left);
        }
        if (top.right != null) {
            q.offer(top.right);
        }
        while (q.size() > 0) {
            // cur is a leaf.
            // Find the root that can attach to cur.
            TreeNode cur = q.poll();
            if (!roots.containsKey(cur.val)) {
                continue;
            }
            TreeNode next = roots.get(cur.val);
            if (next.left != null) {
                cur.left = next.left;
                q.offer(next.left);
            }
            if (next.right != null) {
                cur.right = next.right;
                q.offer(next.right);
            }
            roots.remove(cur.val);
        }

        return roots.size() == 0 && isBST(top, 0, 50001) ? top : null;
    }

    private boolean isBST(TreeNode node, int lo, int hi) {
        if (node == null) {
            return true;
        }
        return lo < node.val && node.val < hi && isBST(node.left, lo, node.val) && isBST(node.right, node.val, hi);
    }
}