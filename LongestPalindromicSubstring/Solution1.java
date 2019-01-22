package LongestPalindromicSubstring;
/**
 * Assume n is the length of s.
 * Worse Time Complexity: O(n^2) (in a string that all the character are same)
 * Best Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 529ms
 * Rank: 5.15%
 */
import java.lang.Math;

public class Solution1 {
	public static String longestPalindrome(String s) {
		if (s.length() == 0) {
			return "";
		}
		String result = "" + s.charAt(0);
		String tempresult = "a";
		// find palindrome with odd length
		for (int i = 1; i < s.length() - 1; i++) {
			tempresult = "" + s.charAt(i);
			int wing = Math.min(i, s.length() - 1 - i);
			if (result.length() > 2 * wing + 1) {
				continue;
			}
			for (int w = 1; w <= wing; w++) {
				if (s.charAt(i - w) == s.charAt(i + w)) {
					tempresult = s.charAt(i - w) + tempresult + s.charAt(i + w);
					if (tempresult.length() > result.length()) {
						result = tempresult;
					}
				} else {
					break;
				}

			}
		}

		if (result.length() == s.length()) {
			return result;
		}

		// find palindrome with even length
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				tempresult = "" + s.charAt(i) + s.charAt(i + 1);
				if (tempresult.length() > result.length()) {
					result = tempresult;
				}
				int wing = Math.min(i, s.length() - 2 - i);
				if (result.length() > 2 * wing + 2) {
					continue;
				}
				for (int w = 1; w <= wing; w++) {
					if (s.charAt(i - w) == s.charAt(i + 1 + w)) {
						tempresult = s.charAt(i - w) + tempresult + s.charAt(i + 1 + w);
						if (tempresult.length() > result.length()) {
							result = tempresult;
						}
					} else {
						break;
					}

				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "asdf";
		String ss = "" + s.charAt(0);
		System.out.println(longestPalindrome("aaaa"));
		System.out.println(longestPalindrome("abcdcda"));
		System.out.println(longestPalindrome("asdfghgfdsa"));
		System.out.println(longestPalindrome("aaaaaabb"));
		System.out.println(longestPalindrome("ffdddrrrr"));
	}

}
