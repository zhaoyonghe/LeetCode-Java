package W.WordPattern_290;

import java.util.HashSet;
import java.util.Set;

/**
 * $$ Time Complexity: O(str.length())
 * $$ Space Complexity: O(str.length())
 */
public class Solution1 {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");

        if (pattern.length() != strs.length) {
            return false;
        }

        String[] map = new String[128];

        for (int i = 0; i < pattern.length(); i++) {
            if (map[pattern.charAt(i)] == null) {
                map[pattern.charAt(i)] = strs[i];
                continue;
            }
            if (!map[pattern.charAt(i)].equals(strs[i])) {
                return false;
            }
        }

        Set<String> set = new HashSet<>();
        for (String str : map) {
            if (str == null) {
                continue;
            }
            if (set.contains(str)) {
                return false;
            }
            set.add(str);
        }
        return true;
    }
}
