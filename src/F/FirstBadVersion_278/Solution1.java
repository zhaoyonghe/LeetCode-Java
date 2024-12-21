package F.FirstBadVersion_278;

/**
 * $$ Time Complexity: O(logn)
 * $$ Space Complexity: O(1)
 */
public class Solution1 extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isBadVersion(mid)) {
                if ((mid == 1) || !isBadVersion(mid - 1)) {
                    return mid;
                }
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return n;
    }
}
