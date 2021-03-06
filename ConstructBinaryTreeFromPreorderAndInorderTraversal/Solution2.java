package ConstructBinaryTreeFromPreorderAndInorderTraversal;

/**
 * Assume n is the number of nodes in root.
 * Best Time Complexity: O(n) when all trees have only right subtree
 * Average Time Complexity: O(nlogn) when tree is "normal"
 * Worse Time Complexity: O(n ^ 2) when all trees have only left subtree
 * Space Complexity: O(1)
 * Runtime: 13ms
 * Rank: 86.83%
 */
public class Solution2 {
    int rindex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return build(preorder, inorder, 0, inorder.length);
    }

    public TreeNode build(int[] preorder, int[] inorder, int istart, int iend) {
        if (istart > iend || rindex >= preorder.length) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[rindex]);
        int index = find(inorder, istart, iend, preorder[rindex]);
        node.left = build(preorder, inorder, istart, index - 1);
        node.right = build(preorder, inorder, index + 1, iend);
        return node;
    }

    public int find(int[] inorder, int istart, int iend, int target) {
        for (int i = istart; i < iend; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
