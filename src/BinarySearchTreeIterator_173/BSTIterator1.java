package BinarySearchTreeIterator_173;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * $$ Assume the nodes count of root is n, height is h.
 * $$ next() Amortized Time Complexity: O(1)
 * $$ hasNext() Amortized Time Complexity: O(1)
 * $$ Space Complexity: O(h)
 */

class BSTIterator1 {
    private Deque<TreeNode> st = new ArrayDeque<>();

    public BSTIterator1(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            this.st.push(cur);
            cur = cur.left;
        }
    }

    public int next() {
        TreeNode node = this.st.pop();
        int val = node.val;
        TreeNode cur = node.right;
        while (cur != null) {
            this.st.push(cur);
            cur = cur.left;
        }
        return val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}

