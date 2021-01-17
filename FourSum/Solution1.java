package FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Assume n is nums.length.
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(1)
 * Runtime: 56ms
 * Rank: 75.78%
 */

class Solution1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        int i = 0;

        while (i < nums.length - 3) {
            int tar = target - nums[i];
            int j = i + 1;
            while (j < nums.length - 2) {
                int start = j + 1;
                int end = nums.length - 1;

                int t = tar - nums[j];

                while (start < end) {
                    if (nums[start] + nums[end] > t) {
                        end -= 1;
                    } else if (nums[start] + nums[end] < t) {
                        start += 1;
                    } else {
                        // nums[start] + start[end] == t
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[start]);
                        temp.add(nums[end]);
                        list.add(temp);

                        start += 1;
                        while (start < end && nums[start] == nums[start - 1]) {
                            start += 1;
                        }
                        end -= 1;
                        while (start < end && nums[end] == nums[end + 1]) {
                            end -= 1;
                        }
                    }
                }

                j += 1;
                while (j < nums.length - 2 && nums[j] == nums[j - 1]) {
                    j += 1;
                }
            }

            // skip the duplicate
            i += 1;
            while (i < nums.length - 3 && nums[i] == nums[i - 1]) {
                i += 1;
            }
        }

        return list;
    }
}