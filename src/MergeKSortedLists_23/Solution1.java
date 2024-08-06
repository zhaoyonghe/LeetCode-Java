package MergeKSortedLists_23;

import java.util.PriorityQueue;

/**
 * $$ Assume k is lists.length and n is node count for all linked lists.
 * $$ Time Complexity: O(nlogk)
 * $$ Space Complexity: O(k)
 */
public class Solution1 {
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
            for (ListNode list : lists) {
                if (list == null) {
                    continue;
                }
                pq.offer(list);
            }
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;

            while (!pq.isEmpty()) {
                ListNode list = pq.poll();
                cur.next = list;
                cur = cur.next;
                if (list.next != null) {
                    pq.offer(list.next);
                }
            }
            return dummy.next;
        }
    }
}
