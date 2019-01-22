package LongestSubstringWithoutRepeatingCharacter;
/**
 * Assume n is the length of s.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 37ms
 * Rank: 85.96%
 */
import java.util.HashMap;
import java.lang.Math;

public class Solution1 {

	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int start = 0;
		int end = 1;
		int length = 1;
		// This map contains characters between start and end.
		// key: character value: index of this character
		HashMap<Character, Integer> map = new HashMap<>();
		map.put(s.charAt(0), 0);
		for (; end < s.length(); end++) {
			if (map.containsKey(s.charAt(end))) {
				int tempstart = map.get(s.charAt(end));
				// We actually do not need to remove these character in the map.
				for (; start <= tempstart; start++) {
					map.remove(s.charAt(start));
				}
				map.put(s.charAt(end), end);
			} else {
				map.put(s.charAt(end), end);
				length = Math.max(end - start + 1, length);
			}
		}
		return length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
