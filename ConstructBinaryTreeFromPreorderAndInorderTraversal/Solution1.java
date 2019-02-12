package ConstructBinaryTreeFromPreorderAndInorderTraversal;
/**
 * Assume n is the number of nodes in root.
 * Time Complexity: O(n) not sure
 * Space Complexity: O(n) not sure
 * Runtime: 13ms
 * Rank: 86.83%
 */
public class Solution1 {
	class Solution {
		int rindex;

		public TreeNode buildTree(int[] inorder, int[] postorder) {
			if (inorder.length == 0) {
				return null;
			}
			rindex = postorder.length - 1;
			return build(inorder, postorder, 0, postorder.length - 1);
		}

		public TreeNode build(int[] inorder, int[] postorder, int istart, int iend) {
			if (istart > iend || rindex < 0) {
				return null;
			}
			TreeNode node = new TreeNode(postorder[rindex]);
			int index = find(inorder, istart, iend, postorder[rindex]);

			rindex -= 1;
			node.right = build(inorder, postorder, index + 1, iend);
			node.left = build(inorder, postorder, istart, index - 1);
			return node;
		}

		public int find(int[] inorder, int istart, int iend, int target) {
			for (int i = istart; i <= iend; i++) {
				if (inorder[i] == target) {
					return i;
				}
			}
			return -1;
		}
	}
}
