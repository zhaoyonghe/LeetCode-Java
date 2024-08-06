package MergeSortedArray_88;

/**
 * Time Complexity: O(m + n)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
    // Important constraints:
    // 1. nums1.length == m + n
    //    nums2.length == n
    //    0 <= m, n <= 200
    //    1 <= m + n <= 200 (input is valid)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int cur = nums1.length - 1;
        while (i >= 0 || j >= 0) {
            // Integer.MIN_VALUE < -10 ^ 9 <= nums1[i], nums2[j] <= 10 ^ 9
            int a = Integer.MIN_VALUE;
            if (i >= 0) {
                a = nums1[i];
            }
            int b = Integer.MIN_VALUE;
            if (j >= 0) {
                b = nums2[j];
            }
            // a, b cannot all be Integer.MIN_VALUE here.
            if (a <= b) {
                nums1[cur] = b;
                j--;
            } else {
                nums1[cur] = a;
                i--;
            }
            cur--;
        }
    }
}
