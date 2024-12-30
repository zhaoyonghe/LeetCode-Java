package C.CountOfRangeSum_327;

/**
 * $$ Time Complexity: O(nlogn)
 * $$ Space Complexity: O(n)
 */

class Solution1 {
    int res = 0;

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] presum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            presum[i + 1] = presum[i] + (long) nums[i];
        }
        // sum(nums[i...j]) == presum[j+1] - presum[i]
        mergeSort(presum, 0, presum.length - 1, lower, upper);
        return res;
    }

    private void mergeSort(long[] a, int start, int end, int lower, int upper) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(a, start, mid, lower, upper);
        mergeSort(a, mid + 1, end, lower, upper);

        int l = mid + 1;
        int r = mid + 1;
        for (int k = start; k <= mid; k++) {
            while (l <= end && (a[l] - a[k]) < (long) lower) {
                l++;
            }
            while (r <= end && (a[r] - a[k]) <= (long) upper) {
                r++;
            }
            res += (r - l);
        }

        // merge
        long[] tmp = new long[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid || j <= end) {
            if (i > mid) {
                tmp[k] = a[j];
                j++;
                k++;
                continue;
            }
            if (j > end) {
                tmp[k] = a[i];
                i++;
                k++;
                continue;
            }
            if (a[i] < a[j]) {
                tmp[k] = a[i];
                i++;
            } else {
                tmp[k] = a[j];
                j++;
            }
            k++;
        }
        i = start;
        j = 0;
        while (j < tmp.length) {
            a[i] = tmp[j];
            i++;
            j++;
        }
    }
}
