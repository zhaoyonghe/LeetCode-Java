package CountGoodNodesInBinaryTree_1448;

/**
 * $$ Assume the number of nodes in root is n, root height is h.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(h)
 */
public class Solution1 {
    public int goodNodes(TreeNode root) {
        return count(root, Integer.MIN_VALUE);
    }

    // return how many good nodes are there under the subtree with node as the root.
    private int count(TreeNode node, int biggestNumSoFar) {
        if (node == null) {
            return 0;
        }
        int current = 0;
        if (node.val >= biggestNumSoFar) {
            current = 1;
            biggestNumSoFar = node.val;
        }
        return current + count(node.left, biggestNumSoFar) + count(node.right, biggestNumSoFar);
    }
}