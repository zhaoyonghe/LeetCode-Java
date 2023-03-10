package WordPatternII;

import java.util.HashSet;

/**
 * Assume pattern.length() is m and str.length() is n.
 * Time Complexity: O(n ^ m)
 * Space Complexity: O(m)
 * Runtime: 29ms
 * Rank: 95.38%
 */
public class Solution2 {
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern.length() == 0 && str.length() == 0) {
            return true;
        }

        if (pattern.length() == 0 || str.length() == 0) {
            return false;
        }
        return wordPatternMatch(pattern.toCharArray(), 0, new String[26], str, new HashSet<String>());
    }

    public boolean wordPatternMatch(char[] pattern, int i, String[] map, String str, HashSet<String> filter) {
        if (i == pattern.length - 1) {
            char c = pattern[i];
            if (map[c - 'a'] == null) {
                return str.length() != 0 && !filter.contains(str);
            } else {
                return str.equals(map[c - 'a']);
            }
        }

        char c = pattern[i];
        if (map[c - 'a'] == null) {
            for (int j = 1; j < str.length(); j++) {
                String s = str.substring(0, j);
                if (filter.contains(s)) {
                    continue;
                }
                map[c - 'a'] = s;
                filter.add(s);
                if (wordPatternMatch(pattern, i + 1, map, str.substring(j, str.length()), filter)) {
                    return true;
                }
                map[c - 'a'] = null;
                filter.remove(s);
            }
            return false;
        } else {
            if (str.startsWith(map[c - 'a'])) {
                return wordPatternMatch(pattern, i + 1, map, str.substring(map[c - 'a'].length(), str.length()),
                        filter);
            } else {

                return false;
            }
        }
    }
}
