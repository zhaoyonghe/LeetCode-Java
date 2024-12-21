package C.ConvertBSTToGreaterTree;

/**
 * Assume the number of nodes in tree root is n.
 * Assume the height of the tree is h.
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * Runtime: 1ms
 * Rank: 98.37%
 */

public class Solution2 {

    public int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }

}
