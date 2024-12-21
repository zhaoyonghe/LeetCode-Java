package E.EncodeAndDecodeStrings_271;

import java.util.ArrayList;
import java.util.List;

/**
 * $$ Assume the count of characters in strs is n.
 * $$ encode() Time Complexity: O(n)
 * $$ decode() Time Complexity: O(n)
 */
public class Codec1 {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append(",").append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int from = 0;
        while (from < s.length()) {
            int[] startLen = getLenFrom(s, from);
            res.add(s.substring(startLen[1] + 1, startLen[1] + 1 + startLen[0]));
            from = startLen[1] + 1 + startLen[0];
        }
        return res;
    }

    private int[] getLenFrom(String s, int from) {
        int len = 0;
        int i = from;
        // All s.charAt(i) will not be out of bound.
        while (s.charAt(i) != ',') {
            len = len * 10 + (s.charAt(i) - '0');
            i++;
        }
        // s.charAt(i) == ','
        return new int[]{len, i};
    }
}