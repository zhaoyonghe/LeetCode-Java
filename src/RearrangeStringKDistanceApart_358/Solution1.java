package RearrangeStringKDistanceApart_358;

import java.util.PriorityQueue;

/**
 * $$ Assume s.length() is n.
 * $$ Time Complexity: O(nlogn)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public String rearrangeString(String s, int k) {
        int[] frequency = new int[128];
        for (char c : s.toCharArray()) {
            frequency[c]++;
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> Integer.compare(frequency[b], frequency[a]));
        PriorityQueue<int[]> indexPQ = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        for (int c = 0; c < 128; c++) {
            if (frequency[c] > 0) {
                pq.offer((char) c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexPQ.isEmpty() && indexPQ.peek()[1] <= i) {
                pq.offer((char) indexPQ.poll()[0]);
            }
            if (pq.isEmpty()) {
                return "";
            }
            char c = pq.poll();
            sb.append(c);
            frequency[c]--;
            if (frequency[c] > 0) {
                indexPQ.offer(new int[]{c, i + k});
            }
        }

        return sb.toString();
    }
}