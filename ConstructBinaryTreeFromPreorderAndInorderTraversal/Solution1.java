package ConstructBinaryTreeFromPreorderAndInorderTraversal;

/**
 * Assume n is the number of nodes in root.
 * Best Time Complexity: O(n) when all trees have only right subtree
 * Average Time Complexity: O(nlogn) when tree is "normal"
 * Worse Time Complexity: O(n ^ 2) when all trees have only left subtree
 * Space Complexity: O(1)
 * Runtime: 19ms
 * Rank: 73.39%
 */
public class Solution1 {
    // Find preorder[0] in inorder, the index is i,
    // then inorder[0 : i - 1] is left subtree, inorder[i + 1 : end] is right subtree.
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        TreeNode root = new TreeNode(0);
        construct(root, preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, true);
        return root.left;
    }

    public void construct(TreeNode root, int[] preorder, int[] inorder, int pstart, int pend, int istart, int iend,
                          boolean isLeft) {
        if (pstart > pend || istart > iend) {
            return;
        }
        int index = find(inorder, istart, iend, preorder[pstart]);
        assert index >= istart && index <= iend;
        int leftlen = index - istart;
        // int rightlen = iend - istart - index - 1;
        TreeNode node = new TreeNode(preorder[pstart]);
        if (isLeft) {
            root.left = node;
        } else {
            root.right = node;
        }
        construct(node, preorder, inorder, pstart + 1, pstart + leftlen, istart, index - 1, true);
        construct(node, preorder, inorder, pstart + leftlen + 1, pend, index + 1, iend, false);
    }

    public int find(int[] inorder, int istart, int iend, int target) {
        for (int i = istart; i <= iend; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
