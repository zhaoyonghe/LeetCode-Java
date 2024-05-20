package BinaryTreeLevelOrderTraversalII_107;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * $$ Assume n is the number of nodes in the tree root.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);
        Collections.reverse(res);
        return res;
    }

    private void helper(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        helper(root.left, level + 1, res);
        helper(root.right, level + 1, res);
    }

}
