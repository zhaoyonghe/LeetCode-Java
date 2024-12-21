package L.LowestCommonAncestorOfABinaryTreeIII_1650;

/**
 * Assume h is the height of the tree.
 * Time Complexity: O(h)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 19ms
 * Rank: 99.22%
 */

public class Solution1 {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p, b = q;
        while (a != b) {
            a = a.parent != null ? a.parent : q;
            b = b.parent != null ? b.parent : p;
        }
        return a;
    }
}