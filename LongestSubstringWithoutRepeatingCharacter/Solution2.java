package LongestSubstringWithoutRepeatingCharacter;

import java.util.HashMap;
/**
 * Time Complexity: O(n) not sure
 * Space Complexity: O(n) not sure
 * Runtime: 37ms
 * Rank: 85.96%
 */
public class Solution2 {
	public int lengthOfLongestSubstring(String s) {
		if (s == null) {
			return 0;
		}
		if (s.length() < 2) {
			return s.length();
		}
		HashMap<Character, Integer> map = new HashMap<>();
		int start = 0;
		int end = 1;
		int length = 1;
		map.put(s.charAt(0), 0);
		while (end < s.length()) {
			if (map.containsKey(s.charAt(end))) {
				start = Math.max(map.get(s.charAt(end)) + 1, start);
			}
			map.put(s.charAt(end), end);
			length = Math.max(end - start + 1, length);
			end++;
		}
		return length;
	}
}
