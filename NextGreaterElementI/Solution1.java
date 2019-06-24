package NextGreaterElementI;
/**
 * Time Complexity: O(nums1.length * nums2.length)
 * Space Complexity: O(1)
 * Runtime: 17ms
 * Rank: 24.50%
 */
public class Solution1 {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			// find nums1[i] in nums2
			int j = 0;
			for (; j < nums2.length; j++) {
				if (nums1[i] == nums2[j]) {
					break;
				}
			}
			j++;
			result[i] = -1;
			// find next greater number
			for (; j < nums2.length; j++) {
				if (nums1[i] < nums2[j]) {
					result[i] = nums2[j];
					break;
				}
			}
		}
		return result;
	}
}
