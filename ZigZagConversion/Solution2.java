package ZigZagConversion;

import java.util.Arrays;

/**
 * Time Complexity: O(max(numRows, s.length()))
 * Space Complexity: O(numRows)
 * Runtime: 49ms
 * Rank: 74.60%
 */
public class Solution2 {
    int convertIndex(int index, int numRows) {
        if (((index / (numRows - 1)) % 2) == 1) {
            return numRows - 1 - index % (numRows - 1);
        } else {
            return index % (numRows - 1);
        }
    }

    public String convert(String s, int numRows) {
        int len = s.length();
        if (numRows < 2 || len <= numRows) {
            return s;
        }
        String[] zigzagcontainer = new String[numRows];
        Arrays.fill(zigzagcontainer, "");
        int orient = 1;
        for (int i = 0; i < len; i++) {
            zigzagcontainer[convertIndex(i, numRows)] += s.charAt(i);
        }
        String result = "";
        for (int i = 0; i < numRows; i++) {
            result += zigzagcontainer[i];
        }
        return result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
