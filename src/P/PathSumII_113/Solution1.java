package P.PathSumII_113;

import java.util.*;

/**
 * $$ Assume the number of the tree nodes is n.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curPath = new ArrayList<>();
        getPaths(root, targetSum, 0, curPath, res);
        return res;
    }

    private void getPaths(TreeNode root, int sum, int cur, List<Integer> curPath, List<List<Integer>> all) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (cur + root.val == sum) {
                curPath.add(root.val);
                all.add(new ArrayList<>(curPath));
                curPath.removeLast();
            }
            return;
        }
        curPath.add(root.val);
        getPaths(root.left, sum, cur + root.val, curPath, all);
        getPaths(root.right, sum, cur + root.val, curPath, all);
        curPath.removeLast();
    }
}
