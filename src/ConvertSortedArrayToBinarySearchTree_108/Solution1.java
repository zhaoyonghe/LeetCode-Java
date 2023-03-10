package ConvertSortedArrayToBinarySearchTree_108;

/**
 * Assume n is the number of tree nodes and h is tree height.
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, start, mid-1);
        node.right = helper(nums, mid+1, end);
        return node;
    }
}
