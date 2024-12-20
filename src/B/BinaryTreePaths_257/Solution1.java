package B.BinaryTreePaths_257;

import java.util.*;

/**
 * $$ Assume the number of nodes in tree root is n.
 * $$ Time Complexity: O(n ^ 2)
 * $$ Space Complexity: O(n)
 */

public class Solution1 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, new ArrayDeque<String>(), res);
        return res;
    }

    public void helper(TreeNode root, Deque<String> cur, List<String> res) {
        cur.push(String.valueOf(root.val));

        if (root.left == null && root.right == null) {
            Iterator<String> stringIterator = cur.descendingIterator();
            StringBuilder sb = new StringBuilder();
            while (stringIterator.hasNext()) {
                sb.append("->").append(stringIterator.next());
            }
            res.add(sb.substring(2));
            cur.pop();
            return;
        }

        if (root.left != null) {
            helper(root.left, cur, res);
        }
        if (root.right != null) {
            helper(root.right, cur, res);
        }
        cur.pop();
    }

}
