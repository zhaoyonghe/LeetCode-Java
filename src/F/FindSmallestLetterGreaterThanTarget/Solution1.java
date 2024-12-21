package F.FindSmallestLetterGreaterThanTarget;

/**
 * Assume n is the length of letters.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 100.00%
 */

public class Solution1 {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                // letters[mid] > target
                if (mid == 0 || letters[mid - 1] <= target) {
                    return letters[mid];
                } else {
                    high = mid - 1;
                }
            }
        }
        return letters[0];
    }
}
