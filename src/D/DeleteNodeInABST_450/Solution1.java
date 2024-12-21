package D.DeleteNodeInABST_450;

/**
 * Assume h is the height of root.
 * Time Complexity: O(h)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 100.00%
 */

public class Solution1 {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode dummy = new TreeNode(1000000, root, null);
        TreeNode prev = dummy;
        TreeNode cur = root;
        while (cur != null && cur.val != key) {
            prev = cur;
            if (cur.val < key) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }

        if (cur == null) {
            return dummy.left;
        }

        if (cur.left == null && cur.right == null) {
            if (prev.left == cur) {
                prev.left = null;
            } else {
                prev.right = null;
            }
        } else if (cur.left == null) {
            if (prev.left == cur) {
                prev.left = cur.right;
            } else {
                prev.right = cur.right;
            }
        } else if (cur.right == null) {
            if (prev.left == cur) {
                prev.left = cur.left;
            } else {
                prev.right = cur.left;
            }
        } else {
            TreeNode tmp = cur.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            cur.right = deleteNode(cur.right, tmp.val);
            cur.val = tmp.val;
        }
        return dummy.left;
    }
}
