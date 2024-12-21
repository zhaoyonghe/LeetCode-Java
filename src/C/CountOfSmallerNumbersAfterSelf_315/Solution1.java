package C.CountOfSmallerNumbersAfterSelf_315;

import java.util.ArrayList;
import java.util.List;

/**
 * Assume n is nums.length.
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 * Runtime: 79ms
 * Rank: 44.89%
 */

public class Solution1 {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nums[i], 0, i);
        }
        mergeSort(pairs, 0, pairs.length - 1);

        for (int i = 0; i < n; i++) {
            nums[pairs[i].index] = pairs[i].count;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(nums[i]);
        }
        return list;
    }

    private void mergeSort(Pair[] pairs, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(pairs, start, mid);
        mergeSort(pairs, mid + 1, end);
        Pair[] buffer = new Pair[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (pairs[i].num <= pairs[j].num) {
                pairs[i].count += j - mid - 1;
                buffer[k++] = pairs[i++];
                continue;
            }
            buffer[k++] = pairs[j++];
        }
        while (i <= mid) {
            pairs[i].count += j - mid - 1;
            buffer[k++] = pairs[i++];
        }
        while (j <= end) {
            buffer[k++] = pairs[j++];
        }
        for (k = 0; k < buffer.length; k++) {
            pairs[start + k] = buffer[k];
        }
    }

    private class Pair {
        public int num;
        public int count;
        public int index;

        Pair(int num, int count, int index) {
            this.num = num;
            this.count = count;
            this.index = index;
        }
    }
}
