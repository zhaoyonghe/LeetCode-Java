package F.FindTheDuplicateNumber_287;

/**
 * Time Complexity: O(nums.length)
 * Space Complexity: O(1)
 * Runtime: 4ms
 * Rank: 89.73%
 */

public class Solution1 {
    public int findDuplicate(int[] nums) {
        // regard nums as a linked list
        // the index of an element indicates the address of the linked list node
        // the value of an element indicates the address of the next linked list node
        // duplicate value in nums means that there are multiple pointer pointing to a same address
        // which means the linked list has a cycle
        // and the same address being pointed is the entrance of the cycle
        int fast = 0;
        int slow = 0;

        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);

        // find the entrance of the cycle
        // assume that a is the length of the no-cycle part, b is the length of the cycle part,
        // when fast and slow meet, fast has rounded n times in the cycle 
        // and meeting point is offset length forward the cycle entrance.
        // we have:
        // a + nb + offset = 2 * (a + offset)  ===>  a = nb - offset
        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        // two pointers will finally meet at the entrance

        return fast;
    }
}
