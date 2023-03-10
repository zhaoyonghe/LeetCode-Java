package WordBreakII;

import java.util.ArrayList;
import java.util.List;

/**
 * Assume s.length() is n.
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(n)
 * Runtime: 5ms
 * Rank: 99.10%
 */
public class Solution1 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        wordBreak(s, wordDict, 0, new Boolean[s.length()], "", result);
        return result;
    }

    public boolean wordBreak(String s, List<String> wordDict, int start, Boolean[] memo, String divStr,
                             List<String> result) {
        if (start == s.length()) {
            result.add(divStr.substring(0, divStr.length() - 1));
            return true;
        }
        if (memo[start] != null && !memo[start]) {
            return false;
        }
        boolean can = false;
        for (String word : wordDict) {
            if (s.startsWith(word, start)
                    && wordBreak(s, wordDict, start + word.length(), memo, divStr + word + " ", result)) {
                can = true;
            }
        }
        memo[start] = can;
        return can;
    }
}
