package LongestIncreasingSubsequence;

/**
 * Assume n is nums.length.
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 * Runtime: 1ms
 * Rank: 99.66%
 */
public class Solution3 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] list = new int[nums.length];
        list[0] = nums[0];
        int sz = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > list[sz - 1]) {
                list[sz] = nums[i];
                sz++;
            } else {
                int index = find(list, sz, nums[i]);
                list[index] = nums[i];
            }
        }
        return sz;
    }

    // find a number in list that is bigger than or equals to num
    // and the index of num should be as small as possible.
    public int find(int[] list, int sz, int num) {
        int low = 0;
        int high = sz - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (list[mid] < num) {
                low = mid + 1;
            } else {
                // list.get(mid) >= num
                if (mid == 0 || list[mid - 1] < num) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
