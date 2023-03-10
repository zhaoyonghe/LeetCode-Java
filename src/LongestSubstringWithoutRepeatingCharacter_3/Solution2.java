package LongestSubstringWithoutRepeatingCharacter_3;

/**
 * Assume n is the length of s.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 2ms
 * Rank: 99.81%
 */
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() < 2) {
            return s.length();
        }
        // this array can contain 128 ascii characters
        // for example: map['a'] -> map[97] 
        // use array instead of hash map can enhance the performance
        int[] map = new int[128];

        int start = 0;
        int end = 1;
        int length = 1;

        // map[character] indicates the last position of this character in string s plus one,
        // if we do not plus one, we cannot distinguish whether a character's last position is zero
        // or this character has not occurred before position end in string s.
        // Thus, we need to minus one if we want to use the last position of a character.
        map[s.charAt(0)] = 1;

        while (end < s.length()) {
            // we need to minus one first
            if (map[s.charAt(end)] - 1 >= start) {
                start = map[s.charAt(end)];
            }
            // we need to plus one when we assign
            map[s.charAt(end)] = end + 1;
            length = Math.max(length, end - start + 1);
            end++;
        }
        return length;
    }
}
