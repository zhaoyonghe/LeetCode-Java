package ValidParentheses;

import java.util.Stack;;
/**
 * Time Complexity: O(s.length())
 * Space Complexity: O(s.length())
 * Runtime: 7ms
 * Rank: 88.05%
 */
public class Solution1 {
	public boolean isMatch(char c1, char c2) {
		if ((c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}')) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isValid(String s) {
		if (s.length() == 0) {
			return true;
		}
		if (s.length() == 1) {
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty()) {
				stack.push(s.charAt(i));
			} else {
				if (isMatch(stack.peek(), s.charAt(i))) {
					stack.pop();
				} else {
					stack.push(s.charAt(i));
				}
			}
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
