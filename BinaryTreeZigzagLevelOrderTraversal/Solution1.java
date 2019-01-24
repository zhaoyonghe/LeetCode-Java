package BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;
/**
 * Assume n is the number of nodes in tree root. 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 1ms
 * Rank: 99.92%
 */
public class Solution1 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		addList(result, root, 0);
		for (int i = 1; i < result.size(); i += 2) {
			result.set(i, reverseList(result.get(i)));
		}
		return result;
	}

	public void addList(List<List<Integer>> list, TreeNode root, int level) {
		if (root == null) {
			return;
		}
		if (list.size() - 1 < level) {
			list.add(new ArrayList<>());
		}
		list.get(level).add(root.val);
		// even level
		addList(list, root.left, level + 1);
		addList(list, root.right, level + 1);
	}

	public List<Integer> reverseList(List<Integer> list) {
		ArrayList<Integer> rev = new ArrayList<>(list.size());
		for (int i = 0; i < list.size(); i++) {
			rev.add(list.get(list.size() - 1 - i));
		}
		return rev;
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
