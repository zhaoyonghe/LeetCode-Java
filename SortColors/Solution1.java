package SortColors;

/**
 * Assume n is nums.length.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 98.75%
 */
public class Solution1 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        // the top pointer of the "zero stack"
        int start = -1;
        // the top pointer of the "two stack"
        int end = nums.length;
        // find the positions of these pointers
        while (start + 1 < end && nums[start + 1] == 0) {
            start++;
        }
        while (end - 1 > start && nums[end - 1] == 2) {
            end--;
        }
        // define a cursor
        // this cursor iterates the nums array 
        int i = start + 1;
        while (i < end) {
            switch (nums[i]) {
                case 0:
                    // when the cursor meets the 0
                    // swap it to the top of the "zero stack"
                    swap(nums, i, start + 1);
                    start++;
                    // If after this step, start == i
                    // then nums[start] == nums[i] == 0.
                    // i should be plus 1.
                    // If after this step, start < i
                    // then nums[start] == 0, nums[i] == 1.
                    // i should be plus 1.
                    i++;
                    break;
                case 1:
                    // when the cursor meets the 1
                    // do nothing
                    // go forward
                    i++;
                    break;
                case 2:
                    // when the cursor meets the 1
                    // swap it to the top of the "two stack"
                    swap(nums, i, end - 1);
                    end--;
                    break;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
