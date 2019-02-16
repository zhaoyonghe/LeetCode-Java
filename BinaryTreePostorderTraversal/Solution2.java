package BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * Assume n is the number of nodes in the tree root.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 2ms
 * Rank: 30.64%
 */
public class Solution2 {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> nodeStack = new Stack<>();
		Stack<Boolean> unfoldStack = new Stack<>();
		nodeStack.push(root);
		unfoldStack.push(true);
		while (!nodeStack.empty()) {
			TreeNode node = nodeStack.pop();
			boolean unfold = unfoldStack.pop();
			if (unfold) {
				// node has no child
				if (node.left == null && node.right == null) {
					list.add(node.val);
				}
				// node has only left child
				else if (node.right == null) {
					nodeStack.push(node);
					nodeStack.push(node.left);
					unfoldStack.push(false);
					unfoldStack.push(true);
				}
				// node has only right child
				else if (node.left == null) {
					nodeStack.push(node);
					nodeStack.push(node.right);
					unfoldStack.push(false);
					unfoldStack.push(true);
				}
				// node has both left and right child
				else {
					nodeStack.push(node);
					nodeStack.push(node.right);
					nodeStack.push(node.left);
					unfoldStack.push(false);
					unfoldStack.push(true);
					unfoldStack.push(true);
				}
			} else {
				list.add(node.val);
			}
		}
		return list;
	}

}
