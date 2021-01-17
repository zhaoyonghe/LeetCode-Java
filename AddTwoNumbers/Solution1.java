package AddTwoNumbers;
/**
 * Assume n is the length of longest linked list.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 41ms
 * Rank: 21.87%
 */

import AddTwoNumbers.ListNode;

public class Solution1 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
        ListNode resulthead = new ListNode(0);
        ListNode curresult = resulthead;
        ListNode curL1 = l1;
        ListNode curL2 = l2;
        boolean first = true;
        while (true) {
            if (curL1 != null && curL2 != null) {
                if (first) {
                    first = false;
                } else {
                    curresult = curresult.next;
                }
                int sum = curL1.val + curL2.val + temp;
                if (sum > 9) {
                    sum -= 10;
                    curresult.val = sum;
                    curresult.next = new ListNode(0);
                    temp = 1;
                } else {
                    curresult.val = sum;
                    curresult.next = new ListNode(0);
                    temp = 0;
                }
                curL1 = curL1.next;
                curL2 = curL2.next;
            } else if (curL1 == null && curL2 == null) {
                if (temp == 1) {
                    curresult = curresult.next;
                    if (curresult.val == 9) {
                        curresult.val = 0;
                        curresult.next = new ListNode(1);
                    } else {
                        curresult.val += temp;
                    }
                    break;
                } else {
                    curresult.next = null;
                    break;
                }
            } else if (curL1 == null) {
                if (temp == 1) {
                    curresult.next = addTwoNumbers(new ListNode(1), curL2);
                } else {
                    curresult.next = curL2;
                }
                break;
            } else if (curL2 == null) {
                if (temp == 1) {
                    curresult.next = addTwoNumbers(new ListNode(1), curL1);
                } else {
                    curresult.next = curL1;
                }
                break;
            }
        }
        return resulthead;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
