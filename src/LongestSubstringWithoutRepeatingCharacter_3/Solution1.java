package LongestSubstringWithoutRepeatingCharacter_3;

import java.util.HashMap;

/**
 * Assume n is the length of s.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 8ms
 * Rank: 40.71%
 */
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() < 2) {
            return s.length();
        }
        // This map contains characters between 0 and end.
        // key: character value: last-occur-index of this character
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 1;
        int length = 1;
        map.put(s.charAt(0), 0);
        while (end < s.length()) {
            if (map.containsKey(s.charAt(end))) {
                // If this character has occurred between start and end, 
                // then update the start.
                start = Math.max(map.get(s.charAt(end)) + 1, start);
            }
            // Update the last-occur-index.
            map.put(s.charAt(end), end);
            length = Math.max(end - start + 1, length);
            end++;
        }
        return length;
    }
}
