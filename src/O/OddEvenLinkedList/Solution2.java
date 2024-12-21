package O.OddEvenLinkedList;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 99.87%
 */
public class Solution2 {
    public ListNode oddEvenList(ListNode head) {
        // divide the list into two lists and then merge them
        if (head == null) {
            return null;
        }
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        ListNode oddWorker = oddHead;
        ListNode evenWorker = evenHead;

        ListNode workerA, workerB;
        workerA = head;
        workerB = head.next;

        int count = 1;
        while (workerB != null) {
            if ((count & 1) == 0) {
                // even
                evenWorker.next = workerA;
                workerA.next = null;
                evenWorker = evenWorker.next;
            } else {
                // odd
                oddWorker.next = workerA;
                workerA.next = null;
                oddWorker = oddWorker.next;
            }
            workerA = workerB;
            workerB = workerB.next;
            count += 1;
        }

        if ((count & 1) == 0) {
            // even
            evenWorker.next = workerA;
            evenWorker = evenWorker.next;
        } else {
            // odd
            oddWorker.next = workerA;
            oddWorker = oddWorker.next;
        }

        oddWorker.next = evenHead.next;
        return oddHead.next;

    }
}
