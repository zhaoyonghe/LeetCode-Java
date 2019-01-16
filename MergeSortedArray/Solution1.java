package MergeSortedArray;

import java.util.Arrays;
/**
 * Time Complexity: O((m + n)log(m + n))
 * Space Complexity: O(1)
 * Runtime: 6ms
 * Rank: 28.43%
 */
public class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	for(int i = 0; i < n; i++) {
    		nums1[m + i] = nums2[i];
    	}
    	Arrays.sort(nums1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
