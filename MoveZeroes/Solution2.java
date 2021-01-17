package MoveZeroes;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 97.05%
 */
public class Solution2 {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            /**
             if(nums[j] == 0) {
             j++;
             } else {
             nums[i] = nums[j];
             i++;
             j++;
             }**/
            // the code below is a simplified version of the code above
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }
    }
}
