package SingleNumberI;

/**
 * Assume n is the length of integer array nums.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 99.52%
 */
public class Solution2 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(Integer.toBinaryString(16));
        System.out.println(Integer.toBinaryString(-16));
        System.out.println(Integer.toBinaryString(-17));
        System.out.println(Integer.toBinaryString(-18));
        System.out.println(Integer.toBinaryString(-18 >> 2));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE ^ 18));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE ^ 18 ^ 18));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE ^ 18 ^ 18 ^ 18));
    }

}
