package PalindromeLinkedList;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 98.16%
 */
public class Solution1 {
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }

            // step 1: get the length of the linked list 
            ListNode worker = head;
            int n = 1;
            while (worker.next != null) {
                worker = worker.next;
                n += 1;
            }

            if (n == 1) {
                return true;
            }

            // step 2: reverse the first half of the linked list
            ListNode headA = null;
            ListNode worker1 = head;
            ListNode worker2 = head.next;
            for (int i = 1; i <= n / 2; i++) {
                worker1.next = headA;
                headA = worker1;
                worker1 = worker2;
                worker2 = worker2.next;
            }

            // step 3: check if it is a palindrome linked list
            ListNode headB = (n & 1) == 0 ? worker1 : worker2;
            while (headA != null) {
                if (headA.val != headB.val) {
                    return false;
                }
                headA = headA.next;
                headB = headB.next;
            }
            return true;
        }
    }
}
