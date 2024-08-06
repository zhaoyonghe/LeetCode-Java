package SortCharactersByFrequency_451;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Assume n is s.length().
 * Time Complexity: O(n * log(n))
 * Space Complexity: O(n)
 * Runtime: 8ms
 * Rank: 95.85%
 */

public class Solution2 {
    // Important constraint:
    // 1. s consists of uppercase and lowercase English letters and digits (can use constant frequency map)
    public String frequencySort(String s) {
        int[][] freq = new int[128][2];
        char[] cs = s.toCharArray();
        for (char c : cs) {
            freq[c][0] = c;
            freq[c][1]++;
        }
        List<int[]> li = Arrays.stream(freq).sorted((a, b) -> Integer.compare(b[1], a[1])).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (int[] en : li) {
            for (int i = 0; i < en[1]; i++) {
                sb.append((char) (en[0]));
            }
        }
        return sb.toString();
    }
}
