package ZigZagConversion_6;

import java.util.*;

/**
 * $$ Time Complexity: O(s.length())
 * $$ Space Complexity: O(s.length())
 */
public class Solution1 {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        List<List<Character>> m = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            m.add(new ArrayList<>());
        }

        int i = 0;
        int add = 1;
        for (char c : s.toCharArray()) {
            m.get(i).add(c);
            if (i == 0) {
                add = 1;
            }
            if (i == numRows - 1) {
                add = -1;
            }
            i += add;
        }

        StringBuilder sb = new StringBuilder();
        for (List<Character> list: m) {
            for (char c: list) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
