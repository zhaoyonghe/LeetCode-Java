package BoundaryOfBinaryTree_545;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Assume n is the number of nodes in the tree root.
 * Time Complexity: O(n)
 * Auxiliary Space Complexity: O(n)
 * Runtime: 1ms
 * Rank: 93.05%
 */
public class Solution1 {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        // root is not null.
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        TreeNode cur = root;
        if (root.left != null) {
            while (true) {
                if (cur.left != null) {
                    cur = cur.left;
                } else if (cur.right != null) {
                    cur = cur.right;
                } else {
                    // never happen.
                }

                if (cur.left == null && cur.right == null) {
                    break;
                }
                res.add(cur.val);
            }
        }

        getLeaves(root, res);

        List<Integer> rb = new ArrayList<>();
        cur = root;
        if (root.right != null) {
            while (true) {
                if (cur.right != null) {
                    cur = cur.right;
                } else if (cur.left != null) {
                    cur = cur.left;
                } else {
                    // never happen.
                }

                if (cur.left == null && cur.right == null) {
                    break;
                }
                rb.add(cur.val);
            }
        }
        Collections.reverse(rb);
        res.addAll(rb);
        return res;
    }

    private void getLeaves(TreeNode node, List<Integer> res) {
        if (node.left != null) {
            if (node.left.left == null && node.left.right == null) {
                res.add(node.left.val);
            } else {
                getLeaves(node.left, res);
            }
        }
        if (node.right != null) {
            if (node.right.left == null && node.right.right == null) {
                res.add(node.right.val);
            } else {
                getLeaves(node.right, res);
            }
        }
    }
}