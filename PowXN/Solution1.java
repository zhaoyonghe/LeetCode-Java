package PowXN;

import java.util.HashMap;

public class Solution1 {
	public HashMap<Integer, Double> plusmap = new HashMap<>();
	public HashMap<Integer, Double> minusmap = new HashMap<>();
	public double[] minus = new double[31];
	public double myPow(double x, int n) {
		if (n < 0) {
			return myMinusPow(x, n);
		} else {
			return myPlusPow(x, n);
		}
	}

	public double myPlusPow(double x, int n) {
		switch (n) {
		case 0:
			return 1;
		case 1:
			return x;
		case 2:
			return x * x;
		}
		double result = x * x;
		// we have this equation: result = x ^ power
		int power = 2;
		while (n >= power << 1 || power << 1 == Integer.MIN_VALUE) {
			power = power << 1;
			if(plusmap.containsKey(power)) {
				result = plusmap.get(power);
			} else {
				result = result * result;
				plusmap.put(power, result);
			}
		}
		return result * myPlusPow(x, n - power);
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
		double result = 1 / (x * x);
		// we have this equation: next result = x ^ power
		int power = -4;
		while (n <= power) {
			result = result * result;
			power = power << 1;
		}
		return result * myMinusPow(x, n - (power >> 1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double i = 5;
		System.out.println(1 << 31 >> 1);
	}

}
