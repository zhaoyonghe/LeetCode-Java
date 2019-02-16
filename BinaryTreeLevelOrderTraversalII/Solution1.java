package BinaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Assume n is the number of nodes in the tree root.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 2ms
 * Rank: 85.11%
 */
public class Solution1 {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		addList(list, root, 0);
		Collections.reverse(list);
		return list;
	}

	public void addList(List<List<Integer>> list, TreeNode root, int level) {
		if (root == null) {
			return;
		}
		if (list.size() - 1 < level) {
			list.add(new ArrayList<Integer>());
		}
		list.get(level).add(root.val);
		addList(list, root.left, level + 1);
		addList(list, root.right, level + 1);
	}

}
