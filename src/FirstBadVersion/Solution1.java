package FirstBadVersion;

/**
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 * Runtime: 21ms
 * Rank: 19.17%
 */
public class Solution1 {
    public class Solution extends VersionControl {
        // Binary search.
        public int firstBadVersion(int n) {
            int start = 1;
            int end = n;
            while (start <= end) {
                int mid = start + ((end - start) >> 1);
                if (isBadVersion(mid)) {
                    if ((mid == 1) || !isBadVersion(mid - 1)) {
                        return mid;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    start = mid + 1;
                }
            }
            return n;
        }
    }

}
