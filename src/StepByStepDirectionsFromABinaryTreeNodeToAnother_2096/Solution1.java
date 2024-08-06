package StepByStepDirectionsFromABinaryTreeNodeToAnother_2096;

/**
 * Assume the number of nodes in the tree is n.
 * Assume the height of the tree is h.
 * Time Complexity: O(n)
 * Auxiliary Space Complexity: O(h)
 * Runtime: 23ms
 * Rank: 92.17%
 */
public class Solution1 {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        String ss = get(root, startValue).reverse().toString();
        String cs = get(root, destValue).reverse().toString();
        // Find ss, cs common prefix.
        int i = 0;
        while (i < Math.min(ss.length(), cs.length()) && ss.charAt(i) == cs.charAt(i)) {
            i++;
        }
        StringBuilder res = new StringBuilder();
        for (int j = 0; j < ss.length() - i; j++) {
            res.append('U');
        }
        return res.append(cs.substring(i)).toString();
    }

    private StringBuilder get(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        // All the values in the tree are unique,
        // so we can stop searching down.
        if (node.val == val) {
            return new StringBuilder();
        }
        StringBuilder sb = get(node.left, val);
        if (sb != null) {
            sb.append('L');
            return sb;
        }
        sb = get(node.right, val);
        if (sb != null) {
            sb.append('R');
        }
        return sb;
    }
}