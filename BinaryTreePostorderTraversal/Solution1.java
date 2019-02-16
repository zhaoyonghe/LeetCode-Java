package BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;
/**
 * Assume n is the number of nodes in the tree root.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
	public List<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		postorderTraversalWithoutReturn(root, list);
		return list;
	}

	public void postorderTraversalWithoutReturn(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		postorderTraversalWithoutReturn(root.left, list);
		postorderTraversalWithoutReturn(root.right, list);
		list.add(root.val);
	}

}
