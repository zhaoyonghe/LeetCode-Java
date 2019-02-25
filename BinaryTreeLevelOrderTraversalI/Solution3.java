package BinaryTreeLevelOrderTraversalI;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * Assume n is the number of nodes in the tree root.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 2ms
 * Rank: 67.98%
 */
public class Solution3 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (true) {
			int numOfNodesThisLevel = queue.size();
			if (numOfNodesThisLevel == 0) {
				break;
			}
			List<Integer> levelResult = new ArrayList<Integer>();
			for (int i = 0; i < numOfNodesThisLevel; i++) {
				TreeNode curNode = queue.poll();
				levelResult.add(curNode.val);
				if (curNode.left != null) {
					queue.offer(curNode.left);
				}
				if (curNode.right != null) {
					queue.offer(curNode.right);
				}
			}
			result.add(levelResult);
		}
		return result;
	}

}
