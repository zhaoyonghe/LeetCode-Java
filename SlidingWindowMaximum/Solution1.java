package SlidingWindowMaximum;

import java.util.TreeSet;

/**
 * Time Complexity: O(nlogk)
 * Space Complexity: O(k)
 * Runtime: 35ms
 * Rank: 30.23%
 */
public class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        if (n == 0 || k == 1) {
            return nums;
        }
        TreeSet<Integer> set = new TreeSet<>(
                (a, b) -> (nums[a] == nums[b] ? a - b : Integer.compare(nums[b], nums[a])));
        for (int i = 0; i < k; i++) {
            set.add(i);
        }

        int[] res = new int[n - k + 1];

        res[0] = nums[set.first()];
        for (int i = 1, j = k; j < n; i++, j++) {
            set.remove(i - 1);
            set.add(j);
            // System.out.println();
            res[i] = nums[set.first()];
        }

        return res;
    }
}
