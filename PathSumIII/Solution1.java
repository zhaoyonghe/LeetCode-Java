package PathSumIII;

/**
 * Assume the number of the tree nodes is n.
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(n)
 * Runtime: 16ms
 * Rank: 79.32%
 */
public class Solution1 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    // calculate the number of paths rooted at node has the sum of sum
    public int dfs(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        int count = 0;
        if (node.val == sum) {
            count += 1;
        }

        count += dfs(node.left, sum - node.val);
        count += dfs(node.right, sum - node.val);

        return count;
    }
}
