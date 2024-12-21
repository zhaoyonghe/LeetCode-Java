package B.BinaryTreePostorderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Assume n is the number of nodes in the tree root.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution3 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> resStack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            resStack.push(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        while (!resStack.isEmpty()) {
            res.add(resStack.pop());
        }
        return res;
    }
}
