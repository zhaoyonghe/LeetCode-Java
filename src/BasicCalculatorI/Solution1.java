package BasicCalculatorI;

import java.util.Stack;

/**
 * Assume n is s.length().
 * Time Complexity: O(n)
 * Best Space Complexity: O(1)
 * Worse Space Complexity: O(n) when all numbers are surrounded by parentheses.
 * Runtime: 86ms
 * Rank: 40.78%
 */
public class Solution1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution1 s = new Solution1();
        System.out.println(s.calculate("(7)-(0)+(4)"));
    }

    /**
     * This function is designed mainly for the numbers that have more than one digit.
     * It can combine the continue digit-characters in the string to one number.
     */
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

    /**
     * @param s
     * @return Does this string indicate a number?
     */
    public boolean isNum(String s) {
        return s.length() > 1 || Character.isDigit(s.charAt(0));
    }

    public int calculate(String s) {
        s = s.replace(" ", "");
        Stack<String> numStack = new Stack<>();
        Stack<String> opStack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            String element = getNextElement(s, i);
            i += element.length();
            if (isNum(element)) {
                if (numStack.empty()) {
                    numStack.push(element);
                } else if (numStack.peek().equals("(")) {
                    numStack.push(element);
                } else {
                    String op = opStack.pop();
                    String num1 = numStack.pop();
                    String num2 = element;
                    if (op.equals("+")) {
                        numStack.push(String.valueOf(Integer.valueOf(num1) + Integer.valueOf(num2)));
                    } else {
                        numStack.push(String.valueOf(Integer.valueOf(num1) - Integer.valueOf(num2)));
                    }
                }
            } else {
                switch (element) {
                    case "(":
                        numStack.push(element);
                        break;
                    case ")":
                        while (true) {
                            if (numStack.peek().equals("(")) {
                                numStack.pop();
                                break;
                            }
                            String num2 = numStack.pop();
                            if (numStack.peek().equals("(")) {
                                numStack.pop();
                                while (!numStack.empty() && isNum(numStack.peek())) {
                                    String num1 = numStack.pop();
                                    String op = opStack.pop();
                                    if (op.equals("+")) {
                                        num2 = String.valueOf(Integer.valueOf(num1) + Integer.valueOf(num2));
                                    } else {
                                        num2 = String.valueOf(Integer.valueOf(num1) - Integer.valueOf(num2));
                                    }
                                }
                                numStack.push(num2);
                                break;
                            }
                            String num1 = numStack.pop();
                            String op = opStack.pop();
                            if (op.equals("+")) {
                                numStack.push(String.valueOf(Integer.valueOf(num1) + Integer.valueOf(num2)));
                            } else {
                                numStack.push(String.valueOf(Integer.valueOf(num1) - Integer.valueOf(num2)));
                            }
                        }

                        break;
                    case "+":
                    case "-":
                        opStack.push(element);
                        break;
                }
            }
        }
        if (numStack.size() > 1) {
            while (numStack.size() > 1) {
                String op = opStack.pop();
                String num2 = numStack.pop();
                String num1 = numStack.pop();
                if (op.equals("+")) {
                    numStack.push(String.valueOf(Integer.valueOf(num1) + Integer.valueOf(num2)));
                } else {
                    numStack.push(String.valueOf(Integer.valueOf(num1) - Integer.valueOf(num2)));
                }
            }
        }
        return Integer.valueOf(numStack.peek());
    }

}
