package FlipStringToMonotoneIncreasing_926;

import java.util.*;
/**
 * Assume n is s.length().
 * Time Complexity: O(n)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 8ms
 * Rank: 94.94
 */
public class Solution1 {
// Important constraints:
// 1. s[i] is either '0' or '1'。
public int minFlipsMonoIncr(String s) {
    char[] cs = s.toCharArray();
    int n = s.length();
    int p0 = 0, p1 = 0;
    if (cs[0] == '0') {
        p1 = 1;
    } else {
        p0 = 1;
    }

    for (int i = 1; i < n; i++) {
        if (cs[i] == '0') {
            p1 = Math.min(p0+1,p1+1);
            continue;
        }
        // cs[i] == '1'
        p1 = Math.min(p0,p1);
        p0++;
    }
    return Math.min(p0, p1);
}
}