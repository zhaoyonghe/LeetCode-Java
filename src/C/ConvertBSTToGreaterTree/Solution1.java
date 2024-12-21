package C.ConvertBSTToGreaterTree;

/**
 * Assume the number of nodes in tree root is n.
 * Assume the height of the tree is h.
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * Runtime: 1ms
 * Rank: 93.25%
 */

public class Solution1 {
    public TreeNode convertBST(TreeNode root) {
        helper(root, 0);
        return root;
    }

    public int helper(TreeNode root, int sumBiggerThanFather) {
        if (root == null) {
            return 0;
        }

        int sumInRightChild = helper(root.right, sumBiggerThanFather);
        int sumInLeftChild = helper(root.left, sumBiggerThanFather + root.val + sumInRightChild);
        int tmp = root.val;
        root.val += (sumInRightChild + sumBiggerThanFather);
        return tmp + sumInLeftChild + sumInRightChild;
    }
}
