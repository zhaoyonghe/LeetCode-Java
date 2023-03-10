package KthLargestElementInAnArray_215;

import java.util.Random;

/**
 * Time Complexity: O(n)
 * Auxiliary Space Complexity: O(logn)
 * Runtime: 1ms
 * Rank: 98.67%
 */
class Solution {
    Random rand = new Random();
    public int findKthLargest(int[] nums, int k) {
        return partition(nums,0,nums.length-1,k);
    }

    private int partition(int[] nums, int s, int e, int k) {
        if (e>s) {
            swap(nums, e, rand.nextInt(e-s)+s);
        }

        int p = nums[e];
        int i = s;
        int j = e - 1;
        while (i <= j) {
            if (nums[i] >= p) {
                i++;
            } else {
                swap(nums,i,j);
                j--;
            }
        }

        swap(nums,i,e);
        if (i-s+1>k) {
            return partition(nums, s, i-1,k);
        } else if (i-s+1<k) {
            return partition(nums, i+1,e,k-i+s-1);
        } else {
            return nums[i];
        }

    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
