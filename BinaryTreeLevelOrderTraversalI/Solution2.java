package BinaryTreeLevelOrderTraversalI;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Assume n is the number of nodes in the tree root.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 5ms
 * Rank: 5.80%
 */
public class Solution2 {
    public List<List<Integer>> result = new ArrayList<>();
    public Deque<TreeNode> nodeQueue = new ArrayDeque<>();
    public Deque<Integer> depthQueue = new ArrayDeque<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        nodeQueue.add(root);
        depthQueue.add(0);
        while (nodeQueue.peek() != null) {
            TreeNode temp = nodeQueue.peek();
            int depth = depthQueue.peek();
            if (temp.left != null) {
                nodeQueue.add(temp.left);
                depthQueue.add(depth + 1);
            }
            if (temp.right != null) {
                nodeQueue.add(temp.right);
                depthQueue.add(depth + 1);
            }
            try {
                result.get(depth).add(temp.val);
            } catch (Exception e) {
                result.add(new ArrayList<>());
                result.get(depth).add(temp.val);
            }
            nodeQueue.pop();
            depthQueue.pop();
        }
        return result;
    }

}
