package MergeKSortedLists_23;

import java.util.PriorityQueue;

/**
 * Assume k is lists.length and n is node count for all linked lists.
 * Time Complexity: O(n * logk)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 4ms
 * Rank: 83.18%
 */
public class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b)->Integer.compare(a.val,b.val));
        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            pq.offer(list);
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (pq.size() != 0) {
            ListNode node = pq.poll();
            // Add node to the result list.
            cur.next = node;
            cur = cur.next;

            if (node.next == null) {
                continue;
            }
            pq.offer(node.next);
        }

        return dummy.next;
    }
}
