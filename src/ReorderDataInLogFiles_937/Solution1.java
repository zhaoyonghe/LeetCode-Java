package ReorderDataInLogFiles_937;

import java.util.Arrays;


/**
 * Assume logs.length is n; the longest log length is m.
 * Time Complexity: O(m * n * log(n))
 * Auxiliary Space Complexity: O(n)
 * Runtime: 4ms
 * Rank: 84.75%
 */

public class Solution1 {
    // Important constraints:
    // 1. All the tokens of logs[i] are separated by a single space.
    // 2. logs[i] is guaranteed to have an identifier and at least one word after the identifier.
    // (a.split(" ", 2) always splits logs into 2 parts)
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            boolean aDig = Character.isDigit(a.charAt(a.length() - 1));
            boolean bDig = Character.isDigit(b.charAt(b.length() - 1));
            if (aDig && bDig) {
                return 0;
            }
            if (aDig) {
                return 1;
            }
            if (bDig) {
                return -1;
            }
            // !aDig && !bDig
            String[] aLog = a.split(" ", 2);
            String[] bLog = b.split(" ", 2);
            if (aLog[1].equals(bLog[1])) {
                return aLog[0].compareTo(bLog[0]);
            }
            return aLog[1].compareTo(bLog[1]);
        });
        return logs;
    }
}