package ConstructBinaryTreeFromInorderAndPostorderTraversal;
/**
 * Assume n is the number of nodes in root.
 * Best Time Complexity: O(n) when all trees have only left subtree
 * Average Time Complexity: O(nlogn) when tree is "normal"
 * Worse Time Complexity: O(n ^ 2) when all trees have only right subtree
 * Space Complexity: O(1)
 * Runtime: 13ms
 * Rank: 86.83%
 */
public class Solution1 {
	class Solution {
		int rindex;
		// Find preorder[end] in inorder, the index is i,
		// then inorder[0 : i - 1] is left subtree, inorder[i + 1 : end] is right subtree.
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
