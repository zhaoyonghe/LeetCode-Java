package WordPatternI;

import java.util.HashSet;
import java.util.Set;

/**
 * Time Complexity: O(pattern.length())
 * Space Complexity: O(str.length())
 * Runtime: 1ms
 * Rank: 100.00%
 */
public class Solution1 {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");

        if (pattern.length() != strs.length) {
            return false;
        }

        String[] map = new String[26];

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map[c - 'a'] != null) {
                if (!map[c - 'a'].equals(strs[i])) {
                    return false;
                }
            } else {
                map[c - 'a'] = strs[i];
            }
        }

        Set<String> set = new HashSet<>();

        for (String s : map) {
            if (s != null) {
                if (set.contains(s)) {
                    return false;
                } else {
                    set.add(s);
                }
            }
        }

        return true;
    }
}
