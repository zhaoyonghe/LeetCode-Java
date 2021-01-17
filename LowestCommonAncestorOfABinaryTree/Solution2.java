package LowestCommonAncestorOfABinaryTree;

/**
 * Assume the number of nodes in root is n.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 15ms
 * Rank: 85.45%
 */


class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode th = null;
        TreeNode le = null;
        TreeNode ri = null;

        if (root.val == p.val || root.val == q.val) {
            if (root.val == p.val) {
                th = p;
            } else {
                th = q;
            }
        }

        if (root.left == null && root.right == null) {
            // if root is the leaf node, return.
            return th;
        }

        // explore left
        if (root.left != null) {
            le = lowestCommonAncestor(root.left, p, q);
        }

        if (le != null) {
            if (le.val != p.val && le.val != q.val) {
                // le must be the answer
                // return it
                return le;
            }
            // le.val == p.val || le.val == q.val
            if (th != null) {
                // th must be p or q now
                assert th.val == p.val || th.val == q.val;
                return root;
            }
            // if th == null,
            // means the other node in p and q will be found in the right subtree
        }
        // if le == null,
        // means that the right subtree should be explored

        // explore right
        if (root.right != null) {
            ri = lowestCommonAncestor(root.right, p, q);
        }

        if (ri != null) {
            if (ri.val != p.val && ri.val != q.val) {
                // ri must be the answer
                // return it
                return ri;
            }
            // ri.val == p.val || ri.val == q.val
            if (th != null) {
                // th must be p or q now
                assert th.val == p.val || th.val == q.val;
                return root;
            }
            // if th == null,
            // means the other node in p and q will be found in the other subtrees
            if (le != null) {
                // le and ri are p and q or q and p
                return root;
            }
        }
        // if ri == null,
        // means that other subtrees should be explored

        // when p or q is the answer
        if (le != null) {
            return le;
        }
        if (ri != null) {
            return ri;
        }
        return th;
    }
}