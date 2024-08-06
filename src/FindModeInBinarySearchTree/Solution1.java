package FindModeInBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Assume the number of nodes in tree root is n.
 * Assume the height of the tree is h.
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * Runtime: 0ms
 * Rank: 100.00%
 */

public class Solution1 {

    public int max = 1;
    public int count = 1;
    public long prev = Long.MIN_VALUE;
    public List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        helper(root);
        int[] res = new int[list.size()];
        int i = 0;
        for (int n : list) {
            res[i] = n;
            i++;
        }
        return res;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.left);
        if (prev == (long) root.val) {
            count++;
            if (count == max) {
                list.add(root.val);
            }
            if (count > max) {
                list.clear();
                list.add(root.val);
                max = count;
            }
        } else {
            count = 1;
            prev = root.val;
            if (count == max) {
                list.add(root.val);
            }
        }
        helper(root.right);
    }

}
