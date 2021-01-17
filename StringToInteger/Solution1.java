package StringToInteger;

/**
 * Time Complexity: O(str.length())
 * Space Complexity: O(1)
 * Runtime: 60ms
 * Rank: 20.98%
 */
public class Solution1 {
    static int[] pow = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

    public String findUseful(String str) {
        String[] result = str.split("\\s+");
        return result[0].length() == 0 ? result[1] : result[0];
    }

    public boolean checkHaveDigit(String str) {
        int len = str.length();
        if (len == 0) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public int myAtoi(String str) {
        if (!checkHaveDigit(str)) {
            return 0;
        }
        str = findUseful(str);
        int len = str.length();
        if (len > 1) {
            if (str.charAt(0) == "0".charAt(0) && !Character.isDigit(str.charAt(1))) {
                return 0;
            }
        }
        StringBuffer sb = new StringBuffer();
        boolean haveNonZeroDigit = false;
        boolean haveDigit = false;
        boolean haveSign = false;
        int signType = 1;
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(str.charAt(i))) {
                if (str.charAt(i) == "0".charAt(0) && haveNonZeroDigit == false) {
                    continue;
                }
                sb.append(str.charAt(i));
                haveDigit = true;
                haveNonZeroDigit = true;
                continue;
            } else {
                if (haveDigit || haveSign) {
                    break;
                }
                if (str.charAt(i) == "+".charAt(0) || str.charAt(i) == "-".charAt(0)) {
                    haveSign = true;
                    if (str.charAt(i) == "-".charAt(0)) {
                        signType = -1;
                    }
                } else {
                    break;
                }
            }
        }
        if (!haveDigit) {
            return 0;
        }
        String pure = sb.toString();
        len = pure.length();
        int result = 0;
        // overflow check
        if (pure.length() > 10 || (pure.length() == 10 && signType == 1 && ("2147483647".compareTo(pure) < 0))
                || (pure.length() == 10 && signType == -1 && ("2147483648".compareTo(pure) < 0))) {
            if (signType == 1) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }

        }
        // pass the check, this number is not overflow
        for (int i = 0; i < len; i++) {
            result += (pure.charAt(i) - 48) * pow[len - 1 - i];
        }
        return signType * result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("+0  8776".split("\\s+")[0]);
        System.out.println("  +0  8776".split("\\s+")[1]);
        System.out.println("  +0  8776".split("\\s+")[2]);
        System.out.println("0".charAt(0) * 1);
        // System.out.println(Character.isDigit("-".charAt(0)));

    }

}
