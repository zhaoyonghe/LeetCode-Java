package SlidingWindowMedian;

import java.util.TreeSet;

/**
 * Time Complexity: O(nlogk)
 * Space Complexity: O(k)
 * Runtime: 33ms
 * Rank: 69.92%
 */
public class Solution1 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (k == 1) {
            double[] res = new double[n];
            for (int i = 0; i < n; i++) {
                res[i] = nums[i];
            }
            return res;
        }

        TreeSet<Integer> left = new TreeSet<>((a, b) -> nums[a] != nums[b] ? Integer.compare(nums[b], nums[a]) : a - b);
        TreeSet<Integer> right = new TreeSet<>(
                (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b);

        // init two queues
        for (int i = 0; i < k; i++) {
            left.add(i);
        }

        while (left.size() > right.size()) {
            right.add(left.pollFirst());
        }

        double[] res = new double[n - k + 1];
        res[0] = (k % 2 == 1) ? (double) (nums[right.first()])
                : ((double) nums[left.first()] + (double) nums[right.first()]) / 2;
        for (int i = 1, j = k; j < n; i++, j++) {
            if (!right.remove(i - 1)) {
                left.remove(i - 1);
            }

            right.add(j);
            left.add(right.pollFirst());

            while (left.size() > right.size()) {
                right.add(left.pollFirst());
            }

            res[i] = (k % 2 == 1) ? (double) (nums[right.first()])
                    : ((double) nums[left.first()] + (double) nums[right.first()]) / 2;
        }

        return res;
    }
}
