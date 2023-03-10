package NextGreaterNodeInLinkedList_1019;

import java.util.*;

/**
 * Assume the length of the linked list is n.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 11ms
 * Rank: 90.92%
 */

public class Solution1 {
    public int[] nextLargerNodes(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int[] res = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= list.get(i)) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(list.get(i));
        }
        return res;
    }
}
