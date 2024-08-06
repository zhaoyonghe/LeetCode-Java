package WordPatternII_291;

import java.util.HashSet;
import java.util.Set;

/**
 * $$ Assume pattern.length() is m and str.length() is n.
 * $$ Time Complexity: O(m * n ^ m)
 * $$ Space Complexity: O(m + n)
 */
public class Solution1 {
    public boolean wordPatternMatch(String pattern, String s) {
        String[] map = new String[128];
        Set<String> set = new HashSet<>();

        return helper(pattern, s, map, set);
    }

    private boolean helper(String pattern, String s, String[] map, Set<String> set) {
        if (pattern.length() == 0) {
            return s.length() == 0;
        }
        if (s.length() == 0) {
            return false;
        }

        char c = pattern.charAt(0);

        if (map[c] != null) {
            if (!s.startsWith(map[c])) {
                return false;
            }
            return helper(pattern.substring(1), s.substring(map[c].length()), map, set);
        }

        // Try matching.
        for (int i = 0; i < s.length(); i++) {
            String matched = s.substring(0, i + 1);
            if (set.contains(matched)) {
                continue;
            }
            map[c] = matched;
            set.add(matched);
            if (helper(pattern.substring(1), s.substring(map[c].length()), map, set)) {
                return true;
            }
            map[c] = null;
            set.remove(matched);
        }

        return false;
    }
}
