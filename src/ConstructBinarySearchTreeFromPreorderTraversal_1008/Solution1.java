package ConstructBinarySearchTreeFromPreorderTraversal_1008;

/**
 * Assume n is the number of nodes in root.
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 * Runtime: 0ms
 * Rank: 100.00%
 */

public class Solution1 {
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1, 0, 100000001);
    }

    private TreeNode helper(int[] preorder, int s, int e, int lo, int hi) {
        if (s > e) {
            return null;
        }
        int i = s + 1;
        int mid = preorder[s];
        for (; i <= e && lo < preorder[i] && preorder[i] < mid; i++) {

        }
        TreeNode node = new TreeNode(mid);
        node.left = helper(preorder, s + 1, i - 1, lo, mid);
        node.right = helper(preorder, i, e, mid, hi);
        return node;
    }
}

