package PowXN;

import java.util.HashMap;

/**
 * Time Complexity: O(logn)
 * Space Complexity: O(logn)
 * Runtime: 23ms
 * Rank: 21.25%
 */
public class Solution1 {
    // key: i
    // value: x ^ i
    public HashMap<Integer, Double> map = new HashMap<>();

    public double myPow(double x, int n) {
        if (n < 0) {
            return myMinusPow(x, n);
        } else {
            return myPlusPow(x, n);
        }
    }

    // Calculate x ^ n by x ^ (n / 2) * x ^ (n / 2)
    // Calculate x ^ n / 2 by x ^ (n / 4) * x ^ (n / 4)
    // ...
    // To sum up, we need to calculate x ^ n, x ^ (n / 2), x ^ (n / 4) ... x ^ 1
    // To calculate each one(from bottom to top), we need O(1) time,
    // and by saving in map, we do not need to recalculate them.
    public double myPlusPow(double x, int n) {
        switch (n) {
            case 0:
                return 1;
            case 1:
                return x;
            case 2:
                return x * x;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            double temp = myPlusPow(x, n >> 1);
            map.put(n >> 1, temp);
            if (n % 2 == 0) {
                return temp * temp;
            } else {
                return temp * temp * x;
            }
        }
    }

    public double myMinusPow(double x, int n) {
        switch (n) {
            case 0:
                return 1;
            case -1:
                return 1 / x;
            case -2:
                return 1 / (x * x);
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            double temp = myMinusPow(x, n >> 1);
            map.put(n >> 1, temp);
            if (n % 2 == 0) {
                return temp * temp;
            } else {
                return temp * temp * x;
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        double i = 5;
        System.out.println(1 << 31 >> 1);
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE - 1));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE + 1));
    }

}
