package ThreeSum_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Assume n is nums.length.
 * Time Complexity: O(n ^ 2)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 18ms
 * Rank: 89.40%
 */
public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        while(i < n - 2) {
            while (i > 0 && i < n-2 && nums[i - 1] == nums[i]) {
                i++;
            }
            int j = i + 1;
            int k = n - 1;
            int target = -nums[i];
            // Two sum problem in an sorted array, O(n).
            while (j < k) {
                if (nums[j] + nums[k] < target) {
                    j++;
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                    for (int a = nums[j]; a == nums[j]&&j<k;j++) {
                    }
                    for (int b = nums[k]; b == nums[k]&&j<k;k--) {
                    }
                }
            }
            i++;
        }
        return res;
    }
}
