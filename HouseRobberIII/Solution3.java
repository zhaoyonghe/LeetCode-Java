package HouseRobberIII;

/**
 * Assume n is the number of nodes in root.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 1ms
 * Rank: 99.38%
 */
public class Solution3 {

    int rob(TreeNode root) {
        int[] result = doRob(root);
        return Math.max(result[0], result[1]);
    }

    int[] doRob(TreeNode node) {
        int[] result = new int[2];
        if (node == null) {
            return result;
        }
        int[] leftResult = doRob(node.left);
        int[] rightResult = doRob(node.right);

        // do not rob this node
        result[0] = Math.max(leftResult[0], leftResult[1]) + Math.max(rightResult[0], rightResult[1]);

        // rob this node
        result[1] = node.val + leftResult[0] + rightResult[0];

        //{max value if do not rob this node, max value if rob this node}
        return result;
    }
}
