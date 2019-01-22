package PalindromeNumber;
/**
 * Time Complexity: O(log10(x))
 * Space Complexity: O(log10(x))
 * Runtime: 99ms
 * Rank: 96.12%
 */
public class Solution1 {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		
		// Convert x to reverse string version.
		// For example, 12345 -> "54321"
		StringBuffer sb = new StringBuffer();
		int temp = x;
		while (temp > 0) {
			sb.append((char) (temp % 10 + 48));
			temp /= 10;
		}
		
		String s = sb.toString();
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
