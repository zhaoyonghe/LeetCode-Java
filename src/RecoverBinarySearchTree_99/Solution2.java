package RecoverBinarySearchTree_99;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Assume the number of the nodes in root is n; root height is h.
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * Runtime: 2ms
 * Rank: 87.61%
 */

public class Solution2 {
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode first = null, second = null;
        TreeNode cur = root;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);

        while (true) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else if (!stack.isEmpty()) {
                cur = stack.pop();
                if (prev.val > cur.val) {
                    if (first == null) {
                        first = prev;
                    }
                    second = cur;
                }
                prev = cur;
                cur = cur.right;
            } else {
                break;
            }
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}
