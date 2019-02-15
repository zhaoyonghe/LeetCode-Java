package MedianOfTwoSortedArrays;
/**
 * Time Complexity: O(log(min(nums1.length, nums2.length)))
 * Space Complexity: O(1)
 * Runtime: 41ms
 * Rank: 97.78%
 */
public class Solution2 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			return findMedianSortedArrays(nums2, nums1);
		}
		int[] a = nums1;
		int[] b = nums2;
		int s = (a.length + b.length + 1) / 2;
		int minleft = 0;
		int maxleft = a.length;
		while (true) {
			int aleft = (minleft + maxleft) / 2;
			int bleft = s - aleft;
			int aleftmax = (aleft == 0 ? Integer.MIN_VALUE : a[aleft - 1]);
			int bleftmax = (bleft == 0 ? Integer.MIN_VALUE : b[bleft - 1]);
			int arightmin = (aleft == a.length ? Integer.MAX_VALUE : a[aleft]);
			int brightmin = (bleft == b.length ? Integer.MAX_VALUE : b[bleft]);
			if (aleftmax > brightmin) {
				maxleft = aleft - 1;
			} else if (bleftmax > arightmin) {
				minleft = aleft + 1;
			} else {
				if ((a.length + b.length) % 2 == 0) {
					return (double) (Math.max(aleftmax, bleftmax) + Math.min(arightmin, brightmin)) / 2;
				} else {
					return Math.max(aleftmax, bleftmax);
				}
			}
		}
	}
}
