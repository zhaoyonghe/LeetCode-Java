package M.MinimumWindowSubstring_76;

/**
 * $$ Assume the length of s is m and t is n.
 * $$ Time Complexity: O(m + n)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int start = 0, end = 0;
        char[] cs = s.toCharArray();
        int ress = 0, rese = Integer.MAX_VALUE;
        while (true) {
            while (end < cs.length) {
                map[cs[end]]--;
                end++;
                if (ok(map)) {
                    break;
                }
            }
            if (!ok(map)) {
                // end == cs.length
                // return answer
                break;
            }
            while (start < end) {
                map[cs[start]]++;
                if (!ok(map)) {
                    // record start, end
                    if (rese - ress > end - start) {
                        rese = end;
                        ress = start;
                    }
                    start++;
                    break;
                }
                start++;
            }
        }
        return rese == Integer.MAX_VALUE ? "" : s.substring(ress, rese);
    }

    private boolean ok(int[] map) {
        for (int cnt : map) {
            if (cnt > 0) {
                return false;
            }
        }
        return true;
    }
}