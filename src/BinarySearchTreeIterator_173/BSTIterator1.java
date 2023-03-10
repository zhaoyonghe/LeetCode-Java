package BinarySearchTreeIterator_173;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Assume the number of the nodes in root is n and the tree height is h.
 * next() Amortized Time Complexity: O(1)
 * hasNext() Amortized Time Complexity: O(1)
 * Space Complexity: O(h)
 * Runtime: 14ms
 * Rank: 99.33%
 */

class BSTIterator1 {
    private Deque<TreeNode> stack = new ArrayDeque<>();
    private TreeNode cur;

    public BSTIterator1(TreeNode root) {
        cur = root;
    }

    public int next() {
        int res;
        while(true) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else if (!this.stack.isEmpty()) {
                cur = stack.pop();
                res = cur.val;
                cur = cur.right;
                return res;
            } else {
                return -1;
            }
        }
    }

    public boolean hasNext() {
        return cur != null || !this.stack.isEmpty();
    }
}

