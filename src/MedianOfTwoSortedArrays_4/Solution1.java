package MedianOfTwoSortedArrays_4;

/**
 * Time Complexity: O(log(min(nums1.length, nums2.length)))
 * Space Complexity: O(1)
 * Runtime: 2ms
 * Rank: 99.88%
 */
public class Solution1 {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        if (m > n) {
            return findMedianSortedArrays(b, a);
        }

        int half = (m+n)/2;
        int s = 0;
        int e = m;
        while (s <= e) {
            int amid = (s+e)/2;
            int bmid = half - amid;
            int aleft = amid-1>=0?a[amid-1]:Integer.MIN_VALUE;
            int aright = amid<m?a[amid]:Integer.MAX_VALUE;
            int bleft = bmid-1>=0?b[bmid-1]:Integer.MIN_VALUE;
            int bright = bmid<n?b[bmid]:Integer.MAX_VALUE;
            if (aleft > bright) {
                e = amid - 1;
            } else if (bleft > aright) {
                s = amid + 1;
            } else {
                // aleft <= bright && bleft <= aright
                if ((m+n)%2==1) {
                    return (double)(Math.min(aright,bright));
                }
                return (double)(Math.max(aleft,bleft)+Math.min(aright,bright))/2;
            }
        }
        return -1;
    }
}
