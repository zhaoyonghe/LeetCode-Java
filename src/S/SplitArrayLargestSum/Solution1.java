package S.SplitArrayLargestSum;

/**
 * Assume n is nums.length.
 * Time Complexity: O(nlogn)
 * Space Complexity: O(1)
 * Runtime: 2ms
 * Rank: 97.56%
 */
class Solution1 {
    public int splitArray(int[] nums, int m) {
        int max = -1;
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            max = max > nums[i] ? max : nums[i];
            sum += nums[i];
        }
        int start = max;
        int end = sum;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            int groupCount = 0;
            int i = 0;
            while (i < n) {
                int csum = 0;
                while (i < n && csum <= mid) {
                    csum += nums[i];
                    i++;
                }
                if (csum > mid) {
                    i--;
                    // csum -= nums[i];
                }
                groupCount++;
            }
            if (groupCount <= m) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
