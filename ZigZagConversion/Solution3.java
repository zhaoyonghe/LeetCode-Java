package ZigZagConversion;
/**
 * Time Complexity: O(len)
 * Space Complexity: O(1)
 * Runtime: 40ms
 * Rank: 85.36%
 */
public class Solution3 {
	public String convert(String s, int numRows) {
		int len = s.length();
		if (numRows < 2 || len <= numRows) {
			return s;
		}
		int cycleLen = 2 * numRows - 2;
		char[] result = new char[len];
		int index = 0;
		// when row = 0
		int endPoint = (int) Math.ceil(len / cycleLen);
		for (int k = 0; k < endPoint; k++) {
			result[index] = s.charAt(k * cycleLen);
			index++;
		}
		// when row = 1 to row = numRows - 2
		for (int i = 1; i < numRows - 1; i++) {
			int k = 0;
			while (true) {
				if (k * cycleLen + i < len) {
					result[index] = s.charAt(k * cycleLen + i);
					index++;
				} else {
					break;
				}
				if ((k + 1) * cycleLen - i < len) {
					result[index] = s.charAt((k + 1) * cycleLen - i);
					index++;
				} else {
					break;
				}
				k++;
			}
		}
		// when numRows = numRows - 1
		endPoint = (int) Math.ceil((len - numRows + 1) / cycleLen);
		for (int k = 0; k < endPoint; k++) {
			result[index] = s.charAt(k * cycleLen + numRows - 1);
			index++;
		}
		return new String(result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution3 s = new Solution3();
		System.out.println(s.convert("PAYPALISHIRING", 3));
	}

}
