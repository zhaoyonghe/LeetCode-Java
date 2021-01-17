package TwoSumII$InputArrayIsSorted;

/**
 * Assume the length of numbers is n
 * Time Complexity: O(nlogn)
 * Space Complexity: O(1)
 * Runtime: 5ms
 * Rank: 34.18%
 */


public class Solution1 {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        for (int i = 0; i < n; i++) {
            int aim = target - numbers[i];
            // i will never reach n - 1
            // low <= n - 1
            int low = i + 1;
            int high = n - 1;
            while (low <= high) {
                int mid = (low + high) >> 1;
                if (numbers[mid] < aim) {
                    low = mid + 1;
                } else if (numbers[mid] > aim) {
                    high = mid - 1;
                } else {
                    // numbers[mid] == aim
                    return new int[]{i + 1, mid + 1};
                }
            }
        }
        return null;
    }
}
