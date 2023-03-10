package MajorityElement;

/**
 * Time Complexity: O(nums.length)
 * Space Complexity: O(nums.length)
 * Runtime: 1ms
 * Rank: 100.00%
 */
public class Solution2 {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 0;

        for (int num : nums) {
            if (majority == num) {
                count += 1;
            } else {
                count -= 1;
                if (count == 0) {
                    majority = num;
                    count += 1;
                }
            }
        }

        return majority;
    }
}
