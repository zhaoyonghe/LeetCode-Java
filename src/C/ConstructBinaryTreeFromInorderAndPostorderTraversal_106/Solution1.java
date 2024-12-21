package C.ConstructBinaryTreeFromInorderAndPostorderTraversal_106;


import java.util.HashMap;
import java.util.Map;

/**
 * Assume n is the number of nodes in root.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 1ms
 * Rank: 96.05%
 */
public class Solution1 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        // The reverse sequence of post order traversal is equivalent to
        // the sequence of root - right subtree - left subtree traversal.
        for (int s = 0, e = n - 1; s < e; s++, e--) {
            int tmp = postorder[s];
            postorder[s] = postorder[e];
            postorder[e] = tmp;
        }
        return helper(postorder, 0, n - 1, inorder, 0, n - 1, map);
    }

    private TreeNode helper(int[] postorder, int ps, int pe, int[] inorder, int is, int ie, Map<Integer, Integer> map) {
        if (ps > pe) {
            return null;
        }
        int imid = map.get(postorder[ps]);
        TreeNode node = new TreeNode(postorder[ps]);
        node.left = helper(postorder, ie - imid + ps + 1, pe, inorder, is, imid - 1, map);
        node.right = helper(postorder, ps + 1, ie - imid + ps, inorder, imid + 1, ie, map);
        return node;
    }
}
