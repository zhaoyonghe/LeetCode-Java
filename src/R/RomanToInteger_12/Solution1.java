package R.RomanToInteger_12;

/**
 * $$ Time Complexity: O(1)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public int romanToInt(String s) {
        int i = s.length() - 1;
        int result = 0;
        while (i > -1) {
            switch (s.charAt(i)) {
                case 'I':
                    result += 1;
                    break;
                case 'V':
                    result += 5;
                    if (i > 0 && s.charAt(i - 1) == 'I') {
                        result -= 1;
                        i -= 1;
                    }
                    break;
                case 'X':
                    result += 10;
                    if (i > 0 && s.charAt(i - 1) == 'I') {
                        result -= 1;
                        i -= 1;
                    }
                    break;
                case 'L':
                    result += 50;
                    if (i > 0 && s.charAt(i - 1) == 'X') {
                        result -= 10;
                        i -= 1;
                    }
                    break;
                case 'C':
                    result += 100;
                    if (i > 0 && s.charAt(i - 1) == 'X') {
                        result -= 10;
                        i -= 1;
                    }
                    break;
                case 'D':
                    result += 500;
                    if (i > 0 && s.charAt(i - 1) == 'C') {
                        result -= 100;
                        i -= 1;
                    }
                    break;
                case 'M':
                    result += 1000;
                    if (i > 0 && s.charAt(i - 1) == 'C') {
                        result -= 100;
                        i -= 1;
                    }
                    break;
                default:
                    try {
                        throw new Exception("illegal input!");
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
            }
            i -= 1;
        }
        return result;
    }
}
