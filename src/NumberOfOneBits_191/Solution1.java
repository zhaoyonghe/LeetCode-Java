package NumberOfOneBits_191;

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 100.00%
 */
public class Solution1 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(0));
        System.out.println(Integer.toBinaryString(1 << 30));
        System.out.println(Integer.toBinaryString(1 << 31));
        System.out.println(Integer.toBinaryString(1 << 32));
        System.out.println(1 << 30);
        System.out.println(1 << 31);
        System.out.println(1 << 32);
    }

    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (((1 << i) & n) != 0) {
                result += 1;
            }
        }
        return result;
    }

}
