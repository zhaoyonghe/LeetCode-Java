package ConvertBinarySearchTreeToSortedDoublyLinkedList_426;

/**
 * Assume the number of nodes in tree root is n.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 0ms
 * Rank: 100.00%
 */

public class Solution1 {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node[] res = processNode(root);
        res[0].left = res[1];
        res[1].right = res[0];
        return res[0];
    }

    private Node[] processNode(Node root) {
        if (root == null) {
            return null;
        }

        Node[] left = processNode(root.left);
        Node[] right = processNode(root.right);
        Node[] res = new Node[]{root, root};

        if (left != null) {
            root.left = left[1];
            left[1].right = root;
            res[0] = left[0];
        }
        if (right != null) {
            root.right = right[0];
            right[0].left = root;
            res[1] = right[1];
        }
        return res;
    }
}
