package PopulatingNextRightPointersInEachNodeII_117;


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
        Node last = null;
        all:
        while (true) {
            Node cur = leftmost;
            while (cur != null) {
                int count = (cur.left == null ? 0 : 1) + (cur.right == null ? 0 : 2);
                if (count == 3) {
                    cur.left.next = cur.right;
                    if (last != null) {
                        last.next = cur.left;
                    }
                    last = cur.right;
                } else if (count == 2) {
                    if (last != null) {
                        last.next = cur.right;
                    }
                    last = cur.right;
                } else if (count == 1) {
                    if (last != null) {
                        last.next = cur.left;
                    }
                    last = cur.left;
                } else {
                    // count == 0
                }

                cur = cur.next;
            }
            last = null;
            while (leftmost.left == null && leftmost.right == null) {
                leftmost = leftmost.next;
                if (leftmost == null) {
                    break all;
                }
            }
            if (leftmost.left != null) {
                leftmost = leftmost.left;
            } else {
                leftmost = leftmost.right;
            }
        }
        return root;
    }
}
