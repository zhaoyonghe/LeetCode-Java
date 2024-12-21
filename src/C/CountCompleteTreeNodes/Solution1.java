package C.CountCompleteTreeNodes;

/**
 * Assume the number of nodes in tree root is n.
 * Time Complexity: O(log(n)^2)
 * Runtime: 0ms
 * Rank: 100.00%
 */

public class Solution1 {
    private int countLeft(TreeNode root) {
        int res = 0;
        TreeNode cur = root;
        while (cur != null) {
            cur = cur.left;
            res++;
        }
        return res;
    }

    private int countRight(TreeNode root) {
        int res = 0;
        TreeNode cur = root;
        while (cur != null) {
            cur = cur.right;
            res++;
        }
        return res;
    }

    public int countNodes(TreeNode root) {
        int le = countLeft(root);
        int ri = countRight(root);
        if (le == ri) {
            return (1 << le) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
