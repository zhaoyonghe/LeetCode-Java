package LowestCommonAncestorOfABinaryTree;

/**
 * Assume the number of nodes in root is n. 
 * Time Complexity: O(n) 
 * Space Complexity: O(1) 
 * Runtime: 15ms 
 * Rank: 85.45%
 */

class Solution3 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}

		if (root.val == p.val || root.val == q.val) {
			return root;
		}

		// root.val != p.val && root.val != q.val

		TreeNode le = lowestCommonAncestor(root.left, p, q);

		if (le != null && le.val != p.val && le.val != q.val) {
			return le;
		}

		TreeNode ri = lowestCommonAncestor(root.right, p, q);

		if (le == null && ri == null) {
			return null;
		}

		if (le != null && ri != null) {
			return root;
		}

		return le == null ? ri : le;
	}
}