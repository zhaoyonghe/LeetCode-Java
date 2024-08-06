package RestoreIPAddresses_93;

import java.util.ArrayList;
import java.util.List;

/**
 * $$ Time Complexity: O(1)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        construct(s, 0, new String[4], 0, res);
        return res;
    }

    private void construct(String s, int i, String[] cur, int count, List<String> res) {
        if (count == 4) {
            if (i == s.length()) {
                res.add(String.join(".", cur));
            }
            return;
        }

        int num = 0;
        int k = i;
        while (k < s.length()) {
            num = num * 10 + (s.charAt(k) - '0');
            if (num >= 256) {
                return;
            }
            cur[count] = s.substring(i, k + 1);
            construct(s, k + 1, cur, count + 1, res);
            if (num == 0) {
                return;
            }
            k++;
        }
    }
}
