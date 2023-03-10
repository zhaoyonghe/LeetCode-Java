package LongestIncreasingSubsequence;

import java.util.ArrayList;

/**
 * Assume n is nums.length.
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 * Runtime: 3ms
 * Rank: 80.68%
 */
public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int index = find(list, nums[i]);
            if (index < 0) {
                list.add(nums[i]);
            } else {
                list.set(index, nums[i]);
            }
        }
        return list.size();
    }

    // find a number in list that is bigger than or equals to num
    // and the index of num should be as small as possible.
    public int find(ArrayList<Integer> list, int num) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (list.get(mid) < num) {
                low = mid + 1;
            } else {
                // list.get(mid) >= num
                if (mid == 0 || list.get(mid - 1) < num) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
