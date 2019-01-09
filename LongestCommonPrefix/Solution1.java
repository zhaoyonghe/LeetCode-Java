package LongestCommonPrefix;
/**
 * Time Complexity: O(the length of common prefix * strs.length)
 * Space Complexity: O(1)
 * Runtime: 6ms
 * Rank: 98.58%
 */
public class Solution1 {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		int count = -1;
		boolean same = true;
		while (same) {
			count++;
			try {
				char c = strs[0].charAt(count);
				for (int i = 1; i < strs.length; i++) {
					if (c != strs[i].charAt(count)) {
						same = false;
						break;
					}
				}
			} catch (Exception e) {
				break;
			}
		}
		return strs[0].substring(0, count);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
