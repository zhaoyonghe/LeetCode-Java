package S.SumOfSubarrayMinimums_907;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Time Complexity: O(arr.length)
 * Space Complexity: O(arr.length)
 * Runtime: 15ms
 * Rank: 96.45%
 */
public class Solution1 {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        Deque<Integer> st = new ArrayDeque<>();
        int[] count = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                int last = st.pop();
                sum += (long) arr[last] * (long) (1 + count[last]) * (long) (i - last);
                count[i] += count[last] + 1;
            }
            st.push(i);
        }
        System.out.println(Arrays.toString(count));
        while (!st.isEmpty()) {
            int last = st.pop();
            sum += (long) arr[last] * (long) (1 + count[last]) * (long) (arr.length - last);
        }
        return (int) (sum % 1000000007);
    }
}