package RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * Runtime: 2ms
 * Rank: 96.72%
 */
public class Solution1 {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        restoreIpAddresses(s, 4, "", list);
        return list;
    }

    public void restoreIpAddresses(String s, int k, String cur, List<String> list) {
        if (k == 0) {
            if (s.length() == 0) {
                list.add(cur.substring(0, cur.length() - 1));
            }
            return;
        }
        if (s.length() == 0) {
            return;
        }
        int curNum = 0;
        if (s.charAt(0) == '0') {
            restoreIpAddresses(s.substring(1, s.length()), k - 1, cur + "0.", list);
        } else {
            for (int i = 0; i < s.length(); i++) {
                curNum = curNum * 10 + (s.charAt(i) - '0');
                if (curNum > 255) {
                    return;
                }
                // System.out.println(cur);
                restoreIpAddresses(s.substring(i + 1, s.length()), k - 1, cur + s.substring(0, i + 1) + ".", list);
            }
        }
        return;
    }
}
