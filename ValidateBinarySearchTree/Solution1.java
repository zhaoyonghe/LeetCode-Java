package ValidateBinarySearchTree;
/**
 * Assume n is the number of nodes in tree root. 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 85.86%
 */
public class Solution1 {
	// Be careful of the case that [5, 2, null, 1, 100]
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isInRangeOf(root.left, (long) (Integer.MIN_VALUE) - 1, (long) root.val)
				&& isInRangeOf(root.right, (long) root.val, (long) (Integer.MAX_VALUE) + 1);
	}

	public boolean isInRangeOf(TreeNode root, long lower, long upper) {
		if (root == null) {
			return true;
		}
		if (root.val < upper && root.val > lower) {
			return isInRangeOf(root.left, lower, root.val) && isInRangeOf(root.right, root.val, upper);
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1 s = new Solution1();
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(1);
		TreeNode c = new TreeNode(3);
		a.left = b;
		a.right = c;
		System.out.println(s.isValidBST(a));
	}

}
