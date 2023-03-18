package BinaryTreeInorderTraversal_94;

import java.util.*;

/**
 * $$ Assume the nodes count of root is n, height is h.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(h)
 */
public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null) {
            st.push(cur);
            cur = cur.left;
        }

        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            res.add(node.val);
            cur = node.right;
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
        }
        return res;
    }
}
