package LowestCommonAncestorOfABinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Assume the number of nodes in root is n.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 19ms
 * Rank: 18.95%
 */

public class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // get paths from root to p and q
        List<TreeNode> pList = new ArrayList<TreeNode>();
        findPath(root, p, pList);
        List<TreeNode> qList = new ArrayList<TreeNode>();
        findPath(root, q, qList);

        // find lowest common ancestor
        TreeNode res = null;
        int i = pList.size() - 1;
        int j = qList.size() - 1;
        while (i >= 0 && j >= 0) {
            if (pList.get(i) == qList.get(j)) {
                res = pList.get(i);
                i--;
                j--;
            } else {
                break;
            }
        }

        return res;
    }

    public boolean findPath(TreeNode root, TreeNode t, List<TreeNode> list) {
        if (root == null) {
            return false;
        }

        if (root == t) {
            list.add(root);
            return true;
        }

        boolean findInleft = findPath(root.left, t, list);
        if (findInleft) {
            list.add(root);
            return true;
        }
        boolean findInRight = findPath(root.right, t, list);
        if (findInRight) {
            list.add(root);
            return true;
        }

        return false;
    }
}
