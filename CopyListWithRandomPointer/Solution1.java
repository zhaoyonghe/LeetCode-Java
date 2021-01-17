package CopyListWithRandomPointer;

import java.util.HashMap;

/**
 * Assume the length of the linked list is n.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 1ms
 * Rank: 89.12%
 */
public class Solution1 {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();

        Node newHead = new Node();
        Node cur = head;
        Node cur1 = newHead;
        while (cur != null) {
            cur1.next = new Node(cur.val, null, null);
            map.put(cur, cur1.next);
            cur = cur.next;
            cur1 = cur1.next;
        }

        cur = head;
        while (cur != null) {
            if (cur.random == null) {
                map.get(cur).random = null;
            } else {
                map.get(cur).random = map.get(cur.random);
            }
            cur = cur.next;
        }

        return newHead.next;
    }
}
