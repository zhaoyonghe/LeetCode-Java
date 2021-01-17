package PathSumIII;

import java.util.HashMap;

/**
 * Assume the number of the tree nodes is n.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 6ms
 * Rank: 91.14%
 */
public class Solution2 {
    public HashMap<Integer, Integer> map = new HashMap<>();
    public int count;

    public int pathSum(TreeNode root, int sum) {
        map.put(0, 1);

        dfs(root, 0, sum);
        return count;
    }

    public void dfs(TreeNode node, int preSum, int sum) {
        if (node == null) {
            return;
        }

        preSum += node.val;

        count += map.getOrDefault(preSum - sum, 0);

        map.compute(preSum, (k, v) -> v == null ? 1 : v + 1);
        dfs(node.left, preSum, sum);
        dfs(node.right, preSum, sum);
        map.compute(preSum, (k, v) -> v == 1 ? null : v - 1);
    }
}
