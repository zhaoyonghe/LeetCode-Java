package C.ClosestBinarySearchTreeValue_270;

/**
 * Assume n is the number of nodes in root.
 * Best Time Complexity: O(logn)
 * Worst Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 1ms
 * Rank: 96.05%
 */

public class Solution1 {
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return -1;
        }
        double val = root.val;
        int other = 0;
        if (target > val) {
            other = closestValue(root.right, target);
        } else {
            other = closestValue(root.left, target);
        }
        if (other == -1 || Math.abs(target - val) < Math.abs(target - (double) other)) {
            return root.val;
        }
        return other;
    }
}
