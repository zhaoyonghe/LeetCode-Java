package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Assume n is nums.length.
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(1)
 * Runtime: 86ms
 * Rank: 67.63%
 */
public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            // two sum problem in an sorted array, O(n)
            int start = i + 1;
            int end = n - 1;
            int target = -nums[i];
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum < target) {
                    start += 1;
                } else if (sum > target) {
                    end -= 1;
                } else {
                    list.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start += 1;
                    end -= 1;
                    while (start < end && nums[start - 1] == nums[start]) {
                        start += 1;
                    }
                    while (start < end && nums[end] == nums[end + 1]) {
                        end -= 1;
                    }
                }
            }
        }
        return list;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = new int[]{1, 2};
        int[] b = new int[]{2, 1};
        System.out.println(a == b);
        System.out.println(Arrays.equals(a, b));
    }

}
