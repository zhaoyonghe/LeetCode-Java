package ShuffleAnArray;

import java.util.Random;
/**
 * Assume the length of nums is n.
 * reset() Time Complexity: O(1)
 * shuffle() Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 219ms
 * Rank: 79.10%
 */
public class Solution {
	private int[] origin;
	private int[] forshuffle;
	private Random random;

	public Solution(int[] nums) {
		origin = nums;
		forshuffle = nums.clone();
		random = new Random();
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return origin;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		if (forshuffle == null) {
			return null;
		}
		for (int i = 1; i < forshuffle.length; i++) {
			int j = random.nextInt(i + 1);
			int temp = forshuffle[i];
			forshuffle[i] = forshuffle[j];
			forshuffle[j] = temp;
		}
		return forshuffle;
	}
}
