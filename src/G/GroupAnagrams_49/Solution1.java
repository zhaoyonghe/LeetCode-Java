package G.GroupAnagrams_49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * $$ Assume the count of characters in strs is n.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String sig = signature(str);
            map.putIfAbsent(sig, new ArrayList<>());
            map.get(sig).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String signature(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (map[i] == 0) {
                continue;
            }
            sb.append((char) i).append(map[i]);
        }
        return sb.toString();
    }
}
