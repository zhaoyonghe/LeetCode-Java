package BinarySearchTreeIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Assume the number of the nodes in root is n.
 * next() Time Complexity: O(1)
 * hasNext() Time Complexity: O(1);
 * Runtime: 23ms
 * Rank: 95.30%
 */

class BSTIterator2 {

    private List<Integer> list = new ArrayList<>();
    private int index = 0;

    public BSTIterator2(TreeNode root) {
        if (root == null) {
            return;
        }

        convert(root);
    }

    private void convert(TreeNode node) {
        if (node == null) {
            return;
        }

        convert(node.left);
        list.add(node.val);
        convert(node.right);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        index++;
        return list.get(index - 1);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return index != list.size();
    }
}

