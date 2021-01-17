package TwoSumII$InputArrayIsSorted;

/**
 * Assume the length of numbers is n
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 98.35%
 */

public class Solution2 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (true) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                // sum == target
                return new int[]{i + 1, j + 1};
            }
        }
    }
}
