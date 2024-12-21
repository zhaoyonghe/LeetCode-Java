package D.DifferentWaysToAddParentheses_241;

import java.util.ArrayList;
import java.util.List;

/**
 * $$ Assume the numbers of numbers in the input is n.
 * $$ Time Complexity: O(n ^ 4)
 * $$ Space Complexity: O(n ^ 2)
 */

public class Solution1 {
    public List<Integer> diffWaysToCompute(String expression) {
        int opsCnt = countOperators(expression);
        ArrayList<Integer>[][] memo = new ArrayList[opsCnt + 1][opsCnt + 1];
        int[] nums = new int[opsCnt + 1];
        char[] ops = new char[opsCnt];
        parseExp(expression, nums, ops);
        return getResults(nums, ops, 0, opsCnt, memo);
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*';
    }

    private int countOperators(String exp) {
        int count = 0;
        for (char c : exp.toCharArray()) {
            if (isOperator(c)) {
                count++;
            }
        }
        return count;
    }

    private void parseExp(String exp, int[] nums, char[] ops) {
        int j = 0;
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (isOperator(c)) {
                ops[j] = c;
                j++;
                continue;
            }
            nums[j] = nums[j] * 10 + (c - '0');
        }
    }

    private int calculate(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        }
        if (op == '-') {
            return a - b;
        }
        return a * b;
    }

    private List<Integer> getResults(int[] nums, char[] ops, int start, int end, ArrayList<Integer>[][] memo) {
        ArrayList<Integer> res = new ArrayList<>();
        if (start == end) {
            res.add(nums[start]);
            return res;
        }
        if (memo[start][end] != null) {
            return memo[start][end];
        }
        for (int i = start; i < end; i++) {
            List<Integer> left = getResults(nums, ops, start, i, memo);
            List<Integer> right = getResults(nums, ops, i + 1, end, memo);
            for (int a : left) {
                for (int b : right) {
                    res.add(calculate(a, b, ops[i]));
                }
            }
        }
        memo[start][end] = res;
        return res;
    }
}
