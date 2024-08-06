package ConstructBinaryTreeFromPreorderAndInorderTraversal_105;

import java.util.HashMap;
import java.util.Map;

/**
 * $$ Assume n is the number of nodes in root.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */


public class Solution1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode helper(int[] preorder, int ps, int pe, int[] inorder, int is, int ie, Map<Integer, Integer> map) {
        if (ps > pe) {
            return null;
        }
        int imid = map.get(preorder[ps]);
        TreeNode node = new TreeNode(preorder[ps]);
        node.left = helper(preorder, ps + 1, ps + imid - is, inorder, is, imid - 1, map);
        node.right = helper(preorder, ps + imid - is + 1, pe, inorder, imid + 1, ie, map);
        return node;
    }
}
