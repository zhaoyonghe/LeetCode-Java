package BasicCalculatorI;

import java.util.Stack;

/**
 * Assume n is s.length().
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 131ms
 * Rank: 30.14%
 */
public class Solution2 {
    public Stack<String> numStack = new Stack<>();
    public Stack<String> opStack = new Stack<>();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution2 s = new Solution2();
        System.out.println(s.calculate("(7 + 6)-(9 - 0 + (6))+(4)"));

    }

    public String getNextElement(String s, int i) {
        if (Character.isDigit(s.charAt(i))) {
            StringBuffer sb = new StringBuffer();
            sb.append(s.charAt(i));
            i++;
            for (; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                } else {
                    break;
                }
            }
            return sb.toString();
        } else {
            return "" + s.charAt(i);
        }
    }

    public boolean isNum(String s) {
        return Character.isDigit(s.charAt(0));
    }

    public void putLeftParentheses(Stack<String> numStack) {
        numStack.push("(");
    }

    public void putRightParentheses(Stack<String> numStack, Stack<String> opStack) {
        String num = numStack.pop();
        numStack.pop();
        putNum(num, numStack, opStack);
    }

    public void putOp(String op, Stack<String> opStack) {
        opStack.push(op);
    }

    public void putNum(String num, Stack<String> numStack, Stack<String> opStack) {
        if (numStack.isEmpty() || numStack.peek().equals("(")) {
            numStack.push(num);
        } else {
            String num2 = num;
            String num1 = numStack.pop();
            String op = opStack.pop();
            switch (op) {
                case "+":
                    putNum(String.valueOf(Integer.valueOf(num1) + Integer.valueOf(num2)), numStack, opStack);
                    break;
                case "-":
                    putNum(String.valueOf(Integer.valueOf(num1) - Integer.valueOf(num2)), numStack, opStack);
                    break;
            }
        }
    }

    public int calculate(String s) {
        s = s.replace(" ", "");
        int i = 0;
        while (i < s.length()) {
            String element = getNextElement(s, i);
            i += element.length();
            if (isNum(element)) {
                putNum(element, numStack, opStack);
            } else {
                switch (element) {
                    case "(":
                        putLeftParentheses(numStack);
                        break;
                    case ")":
                        putRightParentheses(numStack, opStack);
                        break;
                    default:
                        putOp(element, opStack);
                }
            }
        }
        return Integer.valueOf(numStack.peek());
    }

}
