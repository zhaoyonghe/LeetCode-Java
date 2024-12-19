package PopulatingNextRightPointersInEachNodeI_116;

/**
 * Assume n is the number of nodes in root.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Solution2 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node leftmost = root;
        while (leftmost.left != null) {
            Node cur = leftmost;
            while (true) {
                cur.left.next = cur.right;
                if (cur.next == null) {
                    break;
                }
                // cur.next != null
                cur.right.next = cur.next.left;
                cur = cur.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}
