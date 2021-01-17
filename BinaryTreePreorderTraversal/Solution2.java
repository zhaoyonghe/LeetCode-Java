package BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Assume n is the number of nodes in the tree root.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 1ms
 * Rank: 84.01%
 */
public class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode curNode = stack.pop();
            // curNode has no child
            if (curNode.left == null && curNode.right == null) {
                list.add(curNode.val);
            }
            // curNode only has left child
            else if (curNode.right == null) {
                list.add(curNode.val);
                stack.push(curNode.left);
            }
            // curNode only has right child
            else if (curNode.left == null) {
                list.add(curNode.val);
                stack.push(curNode.right);
            }
            // curNode has both left and right child
            else {
                list.add(curNode.val);
                stack.push(curNode.right);
                stack.push(curNode.left);
            }
        }
        return list;
    }

}
