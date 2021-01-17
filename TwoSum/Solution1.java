package TwoSum;

/**
 * Assume n is the length of nums.
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * Runtime: 33ms
 * Rank: 27.84%
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] res = {i, j};
                    return res;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
