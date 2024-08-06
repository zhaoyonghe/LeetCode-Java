package FourSum_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Assume n is nums.length.
 * Time Complexity: O(n ^ 3)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 13ms
 * Rank: 76.95%
 */

class Solution1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // Important constraints:
        // 1 <= nums.length <= 200 (input is not null)
        // -10^9 <= nums[i] <= 10^9 (sum will never overflow)
        if (nums.length < 4) {
            return new ArrayList<>();
        }
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int a = 0;
        while (a < n - 3) {
            int b = a + 1;
            while (b < n - 2) {
                int c = b + 1;
                int d = n - 1;
                while (c < d) {
                    int sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum > target) {
                        d--;
                    } else if (sum < target) {
                        c++;
                    } else {
                        res.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        c++;
                        d--;
                        while (c < d && nums[c - 1] == nums[c]) {
                            c++;
                        }
                        while (c < d && nums[d] == nums[d + 1]) {
                            d--;
                        }
                    }
                }
                b++;
                while (b < n - 2 && nums[b - 1] == nums[b]) {
                    b++;
                }
            }
            a++;
            // Skip the duplicate.
            while (a < n - 3 && nums[a - 1] == nums[a]) {
                a++;
            }
        }
        return res;
    }
}