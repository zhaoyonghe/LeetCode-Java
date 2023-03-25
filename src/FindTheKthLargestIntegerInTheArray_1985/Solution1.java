package FindTheKthLargestIntegerInTheArray_1985;

import java.util.*;
/**
 * $$ Assume nums.length is n, max(nums[i].length) is m.
 * $$ Time Complexity: O(nm)
 * $$ Space Complexity: O(logn)
 */
public class Solution1 {
    public String kthLargestNumber(String[] nums, int k) {
        return nums[select(nums,0,nums.length-1, nums.length-k+1)];
    }

    private Random rand =new Random();

    private int select(String[] nums, int s, int e, int k) {
        if (s==e) {
            return s;
        }

        swap(nums, e, rand.nextInt(e-s+1)+s);

        int i = s;
        int low = s;
        int high = e-1;
        while (i <= high) {
            int comp = compare(nums[i], nums[e]);
            if (comp < 0) {
                swap(nums, low, i);
                low++;
                i = Math.max(i, low);
            } else if (comp >0) {
                swap(nums, i, high);
                high--;
            } else {
                i++;
            }
        }
        // nums[i] is the first nums that >= nums[e]
        swap(nums, i, e);
        if (k <= low-s) {
            // what we want is in the first half: before low
            return select(nums, s,low-1, k);
        }
        if (high-s+1<k) {
            // what we want is in the third half: after high
            return select(nums, high+1, e, k-(high-s+1));
        }
        return i;

    }

    private int compare(String a, String b) {
        if (a.length() == b.length()) {
            return a.compareTo(b);
        }
        return Integer.compare(a.length(), b.length());
    }

    private void swap(String[] nums, int i, int j) {
        String tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}