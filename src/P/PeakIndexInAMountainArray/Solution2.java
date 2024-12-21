package P.PeakIndexInAMountainArray;

/**
 * Assume the length of A is n;
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 * Runtime: 2ms
 * Rank: 100.00%
 */
public class Solution2 {
    public int peakIndexInMountainArray(int[] A) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (mid == 0) {
                if (A[0] > A[1]) {
                    // return mid;
                    return 0;
                } else {
                    // low = mid + 1;
                    low = 1;
                }
            } else if (mid == A.length - 1) {
                if (A[A.length - 2] < A[A.length - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1]) {
                low = mid + 1;
            } else if (A[mid - 1] > A[mid] && A[mid] > A[mid + 1]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return 0;
    }
}
