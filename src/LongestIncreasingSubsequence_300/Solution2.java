package LongestIncreasingSubsequence_300;

import java.util.ArrayList;
import java.util.Collections;

/**
 * $$ Assume n is nums.length.
 * $$ Time Complexity: O(nlogn)
 * $$ Space Complexity: O(n)
 */
public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        // replace the smallest number that is bigger than num.
        for (int num : nums) {
            int index = Collections.binarySearch(list, num);
            if (index >= 0) {
                continue;
            }
            index = -(index + 1);
            if (index == list.size()) {
                list.add(num);
            } else {
                list.set(index, num);
            }
        }
        return list.size();
    }
}
