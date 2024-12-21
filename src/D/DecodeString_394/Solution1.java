package D.DecodeString_394;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Assume n is the product of all numbers in s.
 * Time Complexity: O(n * s.length())
 * Auxiliary Space Complexity: O(s.length())
 * Runtime: 0ms
 * Rank: 100.00%
 */

public class Solution1 {
    public String decodeString(String s) {
        char[] cs = s.toCharArray();
        Map<Integer, Integer> m = new HashMap<>();
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '[') {
                st.push(i);
            }
            if (cs[i] == ']') {
                int previ = st.pop();
                if (cs[previ] != '[') {
                    return "";
                }
                m.put(previ, i);
            }
        }

        return parse(cs, 0, cs.length - 1, m);
    }

    private String parse(char[] cs, int s, int e, Map<Integer, Integer> m) {
        // s                e
        // dsff31[add2[fdsac]]
        StringBuilder sb = new StringBuilder();
        int i = s;
        for (; i <= e && Character.isLetter(cs[i]); i++) {
            sb.append(cs[i]);
        }
        if (i > e) {
            return sb.toString();
        }
        // s   i             e
        // dsff31[add2[fdsac]]
        int repeatNum = 0;
        for (; i <= e && Character.isDigit(cs[i]); i++) {
            repeatNum = repeatNum * 10 + (int) (cs[i]) - (int) ('0');
        }
        //                   j
        // s     i           e
        // dsff31[add2[fdsac]]
        int j = m.get(i);
        String parsed = parse(cs, i + 1, j - 1, m);
        for (int k = 0; k < repeatNum; k++) {
            sb.append(parsed);
        }
        sb.append(parse(cs, j + 1, e, m));
        return sb.toString();
    }
}