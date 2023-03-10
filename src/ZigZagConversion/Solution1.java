package ZigZagConversion;

import java.util.Arrays;

/**
 * Time Complexity: O(max(numRows, s.length()))
 * Space Complexity: O(s.length())
 * Runtime: 62ms
 * Rank: 19.77%
 */
public class Solution1 {
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        int len = s.length();
        String[] zigzagcontainer = new String[numRows];
        Arrays.fill(zigzagcontainer, "");
        int cycle = numRows * 2 - 2;
        int[] reference = new int[cycle];
        int i = 0;
        for (; i < numRows; i++) {
            reference[i] = i;
        }
        i--;
        for (; i > 0; i--) {
            reference[cycle - i] = i;
        }
        i = 0;
        while (i < len) {
            zigzagcontainer[reference[i % cycle]] += s.charAt(i);
            i++;
        }
        String result = "";
        for (i = 0; i < numRows; i++) {
            result += zigzagcontainer[i];
        }
        // System.out.println(Arrays.toString(reference));
        return result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution1 s = new Solution1();
        System.out.println(s.convert("PAYPALISHIRING", 3));
    }

}
