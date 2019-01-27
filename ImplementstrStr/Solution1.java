package ImplementstrStr;
/**
 * Time Complexity: O(the length of the linked list) not sure
 * Space Complexity: O(1)
 * Runtime: 6ms
 * Rank: 81.15%
 */
public class Solution1 {
	public int strStr(String haystack, String needle) {
		// needle is ""
		if (needle.length() == 0) {
			return 0;
		}
		// needle is not "", but haystack is ""
		if (haystack.length() == 0) {
			return -1;
		}
		// both needle and haystack are not ""
		if (needle.length() > haystack.length()) {
			return -1;
		} else {
			int i = 0;
			while (i <= haystack.length() - needle.length()) {
				if (haystack.charAt(i) == needle.charAt(0)) {
					if (compareTwoStrings(haystack.substring(i, i + needle.length()), needle)) {
						return i;
					}
				}
				i += 1;
			}
		}
		return -1;
	}

	public boolean compareTwoStrings(String a, String b) {
		assert a.length() == b.length();
		int len = a.length();
		for (int i = 1; i < len; i++) {
			if (a.charAt(i) != b.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
