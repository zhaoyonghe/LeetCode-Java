package ElementAppearingMoreThan25PercentInSortedArray_1287;

/**
 * Assume n is arr.length.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 0ms
 * Rank: 100.00%
 */

public class Solution1 {
    public int findSpecialInteger(int[] arr) {
        int curNum = -1;
        int count = 0;
        int threshold = arr.length / 4;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != curNum) {
                curNum = arr[i];
                count = 0;
            }
            // arr[i] == curNum
            count++;
            if (count > threshold) {
                return curNum;
            }
        }
        return -1;
    }
}
