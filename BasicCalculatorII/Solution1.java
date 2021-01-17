package BasicCalculatorII;

import java.util.Stack;

/**
 * Assume n is s.length().
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 91ms
 * Rank: 16.01%
 */
public class Solution1 {
    public Stack<String> numStack = new Stack<>();
    public Stack<String> opStack = new Stack<>();

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
        if (Character.isDigit(s.charAt(0))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSafeOpPush(String op) {
        if (opStack.empty()) {
            return true;
        } else {
            if (op.equals("+") || op.equals("-")) {
                return false;
            } else {
                if (opStack.peek().equals("+") || opStack.peek().equals("-")) {
                    return true;
                } else {
                    return false;
                }
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
                numStack.push(element);
            } else {
                while (!isSafeOpPush(element)) {
                    calculate();
                }
                opStack.push(element);
            }
        }
        calculateAll();
        return Integer.valueOf(numStack.peek());
    }

    public void calculate() {
        String num2 = numStack.pop();
        String num1 = numStack.pop();
        String op = opStack.pop();
        switch (op) {
            case "+":
                numStack.push(String.valueOf(Integer.valueOf(num1) + Integer.valueOf(num2)));
                break;
            case "-":
                numStack.push(String.valueOf(Integer.valueOf(num1) - Integer.valueOf(num2)));
                break;
            case "*":
                numStack.push(String.valueOf(Integer.valueOf(num1) * Integer.valueOf(num2)));
                break;
            case "/":
                numStack.push(String.valueOf(Integer.valueOf(num1) / Integer.valueOf(num2)));
                break;
            default:
                break;
        }
    }

    public void calculateAll() {
        while (!opStack.empty()) {
            calculate();
        }
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        s.calculate("3/2");
    }
}
