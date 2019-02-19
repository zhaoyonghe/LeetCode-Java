package ConstructBinaryTreeFromInorderAndPostorderTraversal;
/**
 * Assume n is the number of nodes in root.
 * Time Complexity: O(n) not sure
 * Space Complexity: O(n) not sure
 * Runtime: 19ms
 * Rank: 73.39%
 */
public class Solution1 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0) {
			return null;
		}
		if (preorder.length == 1) {
			return new TreeNode(preorder[0]);
		}
		TreeNode root = new TreeNode(0);
		construct(root, preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, true);
		return root.left;
	}

	public void construct(TreeNode root, int[] preorder, int[] inorder, int pstart, int pend, int istart, int iend,
			boolean isLeft) {
		if (pstart > pend || istart > iend) {
			return;
		}
		int index = find(inorder, istart, iend, preorder[pstart]);
		assert index >= istart && index <= iend;
		int leftlen = index - istart;
		// int rightlen = iend - istart - index - 1;
		TreeNode node = new TreeNode(preorder[pstart]);
		if (isLeft) {
			root.left = node;
		} else {
			root.right = node;
		}
		construct(node, preorder, inorder, pstart + 1, pstart + leftlen, istart, index - 1, true);
		construct(node, preorder, inorder, pstart + leftlen + 1, pend, index + 1, iend, false);
	}

	public int find(int[] inorder, int istart, int iend, int target) {
		for (int i = istart; i <= iend; i++) {
			if (inorder[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		final Integer i = new Integer(2);
		Integer j = i;
	}

}
