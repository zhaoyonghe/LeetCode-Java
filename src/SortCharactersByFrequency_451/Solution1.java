package SortCharactersByFrequency_451;

import java.util.ArrayList;
import java.util.List;

/**
 * Assume n is s.length().
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 3ms
 * Rank: 99.70%
 */

public class Solution1 {
    // Important constraint:
    // 1. s consists of uppercase and lowercase English letters and digits (can use constant frequency map)
    public String frequencySort(String s) {
        char[] map = new char[128];
        for (char c : s.toCharArray()) {
            map[c]++;
        }
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (int i = 0; i < 128; i++) {
            int freq = map[i];
            if (freq == 0) {
                continue;
            }
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add((char) (i));
        }
        StringBuilder sb = new StringBuilder();
        for (int freq = s.length(); freq > 0; freq--) {
            if (buckets[freq] == null) {
                continue;
            }
            for (char c : buckets[freq]) {
                for (int i = 0; i < freq; i++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}