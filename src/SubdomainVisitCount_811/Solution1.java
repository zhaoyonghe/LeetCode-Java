package SubdomainVisitCount_811;

import java.util.*;

/**
 * Time Complexity: O(the number of characters in cpdomains)
 * Space Complexity: O(the number of characters in cpdomains)
 * Runtime: 6ms
 * Rank: 99.66%
 */

public class Solution1 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(cpdomains).forEach(s -> {
            addRepToMap(s, getRep(s), map);
        });
        List<String> res = new ArrayList<>();
        map.forEach((k, v) -> {
            StringBuilder sb = new StringBuilder();
            res.add(sb.append(v).append(" ").append(k).toString());
        });
        return res;
    }

    private int getRep(String s) {
        int res = 0;
        for (char c: s.toCharArray()) {
            if (!Character.isDigit(c)) {
                break;
            }
            res *= 10;
            res += c-'0';
        }
        return res;
    }

    private void addRepToMap(String s, int rep, Map<String, Integer> map) {
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) != '.' && s.charAt(i) != ' ') {
                continue;
            }
            map.compute(s.substring(i+1), (k,v)->(v==null?rep:v+rep));
            if (s.charAt(i) == ' ') {
                return;
            }
        }
    }
}