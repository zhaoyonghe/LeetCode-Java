package I.IntersectionOfTwoArraysI;

import java.util.Arrays;

/**
 * Assume the length of nums1 is m, that of nums2 is n.
 * Time Complexity: O(m + n)
 * Space Complexity: O(max(range of nums1, min(m, n)))
 * Runtime: 1ms
 * Rank: 100.00%
 */
public class Solution2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums1) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        boolean[] bucket = new boolean[max - min + 1];
        for (int num : nums1) {
            bucket[num - min] = true;
        }
        int index = 0;
        int size = nums1.length < nums2.length ? nums1.length : nums2.length;
        int[] result = new int[size];
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] <= max && nums2[i] >= min) {
                int target = nums2[i] - min;
                if (bucket[target]) {
                    bucket[target] = false;
                    result[index] = nums2[i];
                    index += 1;
                }
            }

        }
        return Arrays.copyOf(result, index);
    }
}
