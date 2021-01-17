package RemoveDuplicatesFromSortedArray;

import java.util.Arrays;

/**
 * Assume n is nums.length.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 8ms
 * Rank: 98.90%
 */
public class Solution1 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int result = 1;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (num != nums[i]) {
                num = nums[i];
                nums[result] = num;
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {1, 2, 2, 2, 3, 4, 5, 5, 5, 5, 6};
        System.out.println(removeDuplicates(a));
        System.out.println(Arrays.toString(a));
    }

}
