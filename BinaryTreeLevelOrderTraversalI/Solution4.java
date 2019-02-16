package BinaryTreeLevelOrderTraversalI;

import java.util.ArrayList;
import java.util.List;
/**
 * Assume n is the number of nodes in the tree root.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 1ms
 * Rank: 99.33%
 */
public class Solution4 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		addList(result, root, 0);
		return result;
	}

	public void addList(List<List<Integer>> list, TreeNode root, int level) {
		if (root == null) {
			return;
		}
		// If the max index of list smaller than level.
		if (list.size() - 1 < level) {
			list.add(new ArrayList<>());
		}
		list.get(level).add(root.val);
		addList(list, root.left, level + 1);
		addList(list, root.right, level + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
