package CopyListWithRandomPointer_138;

import java.util.HashMap;
import java.util.Map;

/**
 * $$ Assume the length of the linked list is n.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(0);
        Node worker = dummy;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            worker.next = new Node(cur.val);
            worker = worker.next;
            map.put(cur, worker);
            cur = cur.next;
        }

        cur = head;
        worker = dummy.next;
        while (cur != null) {
            worker.random = map.get(cur.random);
            cur = cur.next;
            worker = worker.next;
        }
        return dummy.next;
    }
}
