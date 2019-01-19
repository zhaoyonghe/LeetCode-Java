package BinaryTreeInorderTraversal;

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
	ArrayList<Integer> result = new ArrayList<>();

	public List<Integer> inorderTraversal(TreeNode root) {
		inorderTraversalWithoutReturn(root);
		return result;
	}

	public void inorderTraversalWithoutReturn(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderTraversalWithoutReturn(root.left);
		result.add(root.val);
		inorderTraversalWithoutReturn(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
