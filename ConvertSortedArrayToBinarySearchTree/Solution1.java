package ConvertSortedArrayToBinarySearchTree;

/**
 * Assume n is the number of nodes in the tree root.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 97.11%
 */
public class Solution1 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return nums == null || nums.length == 0 ? null : builder(nums, 0, nums.length - 1);
    }

    public TreeNode builder(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = builder(nums, start, mid - 1);
        node.right = builder(nums, mid + 1, end);
        return node;
    }
}
