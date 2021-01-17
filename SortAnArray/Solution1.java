package SortAnArray;

/**
 * Assume n is nums.length.
 * Time Complexity: O(nlogn)
 * Space Complexity: O(logn)
 * Runtime: 10ms
 * Rank: 85.87%
 */

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<Integer> sortArray(int[] nums) {
        qsort(nums, 0, nums.length - 1);
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            res.add(num);
        }
        return res;
    }

    public void qsort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = nums[right];
        int i = left - 1;
        int j = right;
        int k = left;

        while (k < j) {
            if (nums[k] < pivot) {
                i++;
                swap(nums, k, i);
                k++;
            } else if (nums[k] > pivot) {
                j--;
                swap(nums, k, j);
            } else {
                k++;
            }
        }
        swap(nums, k, right);
        qsort(nums, left, i);
        qsort(nums, j, right);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
