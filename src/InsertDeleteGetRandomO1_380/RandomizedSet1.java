package InsertDeleteGetRandomO1_380;

import java.util.*;

/**
 * Constructor Time Complexity: O(1)
 * insert() Time Complexity: O(1)
 * remove() Time Complexity: O(1)
 * getRandom() Time Complexity: O(1)
 * Space Complexity: O(capacity)
 * Runtime: 21ms
 * Rank: 97.17%
 */

class RandomizedSet1 {
    List<Integer> nums = new ArrayList<>();
    Map<Integer, Integer> locs = new HashMap<>();
    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet1() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (locs.containsKey(val)) {
            return false;
        }
        locs.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!locs.containsKey(val)) {
            return false;
        }
        int loc = locs.get(val);
        int last = nums.size()-1;
        // swap
        int tmp = nums.get(loc);
        nums.set(loc, nums.get(last));
        nums.set(last, tmp);
        // adjust
        locs.put(nums.get(loc), loc);
        nums.remove(last);
        locs.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}