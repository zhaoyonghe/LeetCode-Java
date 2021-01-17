package BinarySearchTreeIterator;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Assume the number of the nodes in root is n.
 * next() Time Complexity: O(1)
 * hasNext() Time Complexity: O(1);
 * Runtime: 25ms
 * Rank: 47.80%
 */

class BSTIterator1 {

    private TreeNode root;
    private Deque<TreeNode> path = new ArrayDeque<>();
    private Deque<Boolean> status = new ArrayDeque<>();

    public BSTIterator1(TreeNode root) {
        if (root == null) {
            return;
        }
        this.root = root;
        path.push(root);
        status.push(false);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        while (true) {
            TreeNode cur = path.pop();
            boolean unexplored = status.pop();

            if (unexplored || (cur.left == null && cur.right == null)) {
                return cur.val;
            }

            if (cur.right != null) {
                path.push(cur.right);
                status.push(false);
            }
            path.push(cur);
            status.push(true);
            if (cur.left != null) {
                path.push(cur.left);
                status.push(false);
            }
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !path.isEmpty();
    }
}

