package P.PeakIndexInAMountainArray;

/**
 * Assume the length of A is n;
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 4ms
 * Rank: 52.69%
 */
public class Solution1 {
    public int peakIndexInMountainArray(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                return i;
            }
        }
        return 0;
    }
}
