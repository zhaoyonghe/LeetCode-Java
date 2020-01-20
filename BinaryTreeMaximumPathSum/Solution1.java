package BinaryTreeMaximumPathSum;
/**
 * Assume the number of the nodes in root is n.
 * Assume the height of the tree is h.
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * Runtime: 1ms
 * Rank: 100.00%
 */
public class Solution1 {
	private int res = Integer.MIN_VALUE;

	private int maxSum(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int le = maxSum(node.left);
		int ri = maxSum(node.right);

		// this node connects left and right
		int conn = node.val + Math.max(0, le) + Math.max(0, ri);
		//
		int noconn = node.val + Math.max(0, Math.max(le, ri));

		res = Math.max(res, conn);
		return noconn;
	}

	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		maxSum(root);
		return res;
	}
}
