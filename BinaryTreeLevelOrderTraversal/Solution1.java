package BinaryTreeLevelOrderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/**
 * Assume n is the number of nodes in the tree root.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 8ms
 * Rank: 3.97%
 */
public class Solution1 {
	public class TreeNodeWithDepth {
		public TreeNode treenode = null;
		public int depth = 0;

		public TreeNodeWithDepth(TreeNode treenode, int depth) {
			super();
			this.treenode = treenode;
			this.depth = depth;
		}
	}

	public Deque<TreeNodeWithDepth> queue = new ArrayDeque<>();
	public List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return result;
		}
		queue.add(new TreeNodeWithDepth(root, 0));
		while (queue.peek() != null) {
			TreeNodeWithDepth temp = queue.peek();
			if (temp.treenode.left != null) {
				queue.add(new TreeNodeWithDepth(temp.treenode.left, temp.depth + 1));
			}
			if (temp.treenode.right != null) {
				queue.add(new TreeNodeWithDepth(temp.treenode.right, temp.depth + 1));
			}
			try {
				result.get(temp.depth).add(temp.treenode.val);
			} catch (Exception e) {
				result.add(new ArrayList<Integer>());
				result.get(temp.depth).add(temp.treenode.val);
			}
			queue.pop();
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();

	}

}
