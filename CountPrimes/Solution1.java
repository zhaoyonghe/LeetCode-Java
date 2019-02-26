package CountPrimes;
/**
 * Time Complexity: O() not sure
 * Space Complexity: O(n)
 * Runtime: 14ms
 * Rank: 95.56%
 */
public class Solution1 {
	public int countPrimes(int n) {
		if (n == 0) {
			return 0;
		}
		boolean[] records = new boolean[n];
		int stop = (int) Math.floor(Math.sqrt(n));
		for (int i = 2; i <= stop; i++) {
			if (!records[i]) {
				for (int temp = i + i; temp < n; temp += i) {
					records[temp] = true;
				}
			}
		}
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (!records[i]) {
				count += 1;
			}
		}
		return count;
	}

}
