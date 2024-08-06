package StringToInteger;

/**
 * Time Complexity: O(str.length())
 * Space Complexity: O(1)
 * Runtime: 28ms
 * Rank: 87.44%
 */
public class Solution2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("2147483647".compareTo("7"));
    }

    public int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        int index = 0;
        while (index < str.length() && str.charAt(index) == ' ') {
            index += 1;
        }
        int signType = 1;
        if (index < str.length() && str.charAt(index) == '+') {
            index += 1;
        } else if (index < str.length() && str.charAt(index) == '-') {
            index += 1;
            signType = -1;
        } else if (index < str.length() && !Character.isDigit(str.charAt(index))) {
            return 0;
        }
        StringBuffer sb = new StringBuffer();
        boolean onTheTop = true;
        // boolean haveNumber = false;
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            // haveNumber = true;
            if (onTheTop && str.charAt(index) == '0') {
                index += 1;
                continue;
            }
            onTheTop = false;
            sb.append(str.charAt(index));
            if (sb.length() > 10) {
                if (signType == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            index += 1;
        }
        if (sb.length() == 0) {
            return 0;
        }
        String pure = sb.toString();
        int len = pure.length();
        if ((len == 10 && signType == 1 && ("2147483647".compareTo(pure) < 0))
                || (len == 10 && signType == -1 && ("2147483648".compareTo(pure) < 0))) {
            if (signType == 1) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
        int result = 0;
        for (int i = 0; i < len; i++) {
            result = result * 10 + (pure.charAt(i) - 48);
        }
        return signType * result;

    }

}
