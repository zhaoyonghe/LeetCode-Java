package TextJustification_68;

import java.util.*;

/**
 * Assume n is the length of words.
 * Time Complexity: O(n)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 0ms
 * Rank: 100.00%
 */

public class Solution1 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        // Important restriction:
        // words[i].length <= maxWidth.
        // 1 <= words.length <= 300
        // 1 <= words[i].length <= 20
        List<String> res = new ArrayList<>();
        int lineStart = 0;
        int lineChars = words[0].length();
        int lineWords = 1;
        for (int i = 1; i < words.length; i++) {
            if (lineChars + words[i].length() + lineWords > maxWidth) {
                res.add(fullJustify(words, lineStart, i-1, maxWidth-lineChars));
                lineStart = i;
                lineChars = words[i].length();
                lineWords = 1;
                continue;
            }
            lineChars += words[i].length();
            lineWords++;
        }

        res.add(leftJustify(words, lineStart, words.length-1, maxWidth-lineChars-lineWords+1));

        return res;
    }

    private String leftJustify(String[] words, int start, int end, int trailingSpaces) {
        StringBuffer sb = new StringBuffer();
        sb.append(words[start]);
        for (int i = start + 1; i <= end; i++) {
            sb.append(' ');
            sb.append(words[i]);
        }
        sb.append(spacesChars(trailingSpaces));
        return sb.toString();
    }

    private String fullJustify(String[] words, int start, int end, int spaces) {
        StringBuffer sb = new StringBuffer();
        sb.append(words[start]);
        if (start == end) {
            sb.append(spacesChars(spaces));
            return sb.toString();
        }
        int n = end - start;
        int threshold = spaces - (spaces / n) * n;
        for (int i = start + 1; i <= end; i++) {
            sb.append(spacesChars((spaces / n)+(i-start<=threshold?1:0)));
            sb.append(words[i]);
        }
        return sb.toString();
    }

    private char[] spacesChars(int len) {
        char[] res = new char[len];
        Arrays.fill(res, ' ');
        return res;
    }
}