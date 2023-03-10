package ContainsDuplicateIII;

import java.util.HashMap;

/**
 * Time Complexity: O(min(kn,tn))
 * Space Complexity: O(nums.length)
 * Runtime: 6ms
 * Rank: 86.28%
 */
public class Solution1 {
    // assume n is nums.length
    // k cannot be 0, but can be positive integers
    // t can be 0 and positive integers
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 1) {
            return false;
        }
        // after this statement, nums at least has 2 elements
        if (t > (k >> 1)) {
            if (k >= nums.length) {
                k = nums.length - 1;
            }
            // search range: [0, k]
            // kn
            for (int i = 0; i <= k; i++) {
                for (int j = i + 1; j <= k; j++) {
                    // -2147483648 - 2147483646 = 2
                    // must cast to long
                    if (Math.abs((long) nums[i] - (long) nums[j]) <= t) {
                        return true;
                    }
                }
            }
            int start = 1;
            int end = k + 1;
            while (end < nums.length) {
                for (int i = start; i < end; i++) {
                    if (Math.abs((long) nums[i] - (long) nums[end]) <= t) {
                        return true;
                    }
                }
                start += 1;
                end += 1;
            }
            return false;
        } else {
            // search range: [-t, t]
            // tn
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = nums[i] - t; j <= nums[i] + t; j++) {
                    if (map.containsKey(j)) {
                        if (i - map.get(j) <= k) {
                            return true;
                        }
                    }
                }
                map.put(nums[i], i);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE - 2147483646);
    }


}
