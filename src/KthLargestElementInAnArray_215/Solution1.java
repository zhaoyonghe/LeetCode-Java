package KthLargestElementInAnArray_215;

/**
 * $$ Assume n is nums.length.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(logn)
 */
class Solution1 {
    public int findKthLargest(int[] nums, int k) {
        return select(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    private int select(int[] nums, int start, int end, int k) {
        int i = start, j = end - 1;
        while (i <= j) {
            if (nums[i] <= nums[end]) {
                i++;
                continue;
            }
            // nums[i] > nums[end]
            swap(nums, i, j);
            j--;
        }
        swap(nums, i, end);
        // se: nums[start~i] g: nums[i+1~end]
        // does nums[i] rank at k-th in nums[start~end]?
        if (i - start + 1 < k) {
            return select(nums, i + 1, end, k - (i - start + 1));
        } else if (i - start + 1 > k) {
            return select(nums, start, i - 1, k);
        } else {
            // i - start + 1 == k
            return nums[i];
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
