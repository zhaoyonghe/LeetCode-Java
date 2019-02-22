package SingleNumberII;
/**
 * Assume n is the length of integer array nums.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 96.77%
 */
public class Solution1 {
	public int singleNumber(int[] nums) {
		// As with the previous problem, we can still solve it by summation.
		// This idea can also be extended to any parameter K, P problem:
		// each element of the input array appears K times, 
		// only one appears P times, 
		// and find the number of individual only p times.
		// From the first question, 
		// we can probably see that the key to solving this kind of problem
		// is to traverse all elements and do some reduction operation, 
		// which needs periodicity, 
		// then the number after traversal is the single number we are looking for. 
		// For example, in the first topic, the xor operation is used.
		// If an even number occurs, then the xor will become zero, 
		// then we can solve the problem that K is even and P is odd in the same way.
		// So for this problem, 
		// we need to find an operation that causes a number to appear K times and then return to its original state,
		// similar to the concept of state machine. 
		// It may be hard to think directly. Never mind. Let's go step by step.
		
		// Step1: Build a counter. If the coming bit is 1 ,then add 1.
		// For example, bit3, bit2 and bit1 indicate a 3-bit counter.
		// It is: when bit3 = 1, bit2 = 0, bit1 = 1, counter is 5, etc..
		// We can use the following code to implement this counter:
		// bit3 = bit3 ^ (bit2 & bit1 & newbit)
		// bit2 = bit2 ^ (bit1 & newbit)
		// bit1 = bit1 ^ newbit
		// This is a 3-bit example. Generally, we need m bits that can ensure 2 ^ m >= K. 
		
		
		// Step2: Add mask to this counter. If the counter is K, then counter becomes 0.
		// For example, if K = 6(we need 3 bits), then mask should be ~(bit3 & bit2 & ~bit1).
		// And then do: bit3 = bit3 & mask, bit2 = bit2 & mask, bit1 = bit1 & mask.
		// For example, if K = 10(we need 4 bits), then mask should be ~(bit4 & ~bit3 & bit2 & ~bit1).
		// And then do: bit4 = bit4 & mask, bit3 = bit3 & mask, bit2 = bit2 & mask, bit1 = bit1 & mask.
		// Now you can know the pattern.
		
		// Step3: How to get the result?
		// We need 32 m-bit counter(2 ^ m >= K) to monitor 32 bits in an integer.
		// Assume i is the index of bit and this bit in the binary form of P % K is 1.
		// Finally the No.i bit of each counter combined will be the result.
		
		// P.S. When P % K equals to 0, this method is invalid.
		// Assume n is the length of integer array nums.
		// Time Complexity: O(nlogK)
		// Space Complexity: O(logK)
		
		int x2 = 0;
		int x1 = 0;
		int mask = 0;
		for (int num : nums) {
			x2 = x2 ^ (x1 & num);
			x1 = x1 ^ num;
			mask = ~(x2 & x1);
			x2 = x2 & mask;
			x1 = x1 & mask;
		}
		return x1;
	}
}
