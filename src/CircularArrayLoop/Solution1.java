package CircularArrayLoop;

/**
 * Assume n is nums.length.
 * Best Time Complexity: O(n) when return is true
 * Worse Time Complexity: O(n ^ 2) when return is false
 * Space Complexity: O(1)
 * Runtime: 19ms
 * Rank: 0.00%
 */
public class Solution1 {
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int len = nums.length;
        // judge nums[i] one by one
        for (int i = 0; i < len; i++) {
            // move forward
            if (nums[i] > 0) {
                int curi = i;
                // times that curi pass the index of len - 1
                int crossLine = 0;
                // if nums[curi] == 0, we will stay in place forever
                // if nums[curi] % len == 0, we will stay in place forever
                // if these things happened, there will be no loop in array that start from curi
                while (nums[curi] > 0 && nums[curi] % len != 0) {
                    // crosses too many times, but has no loop
                    if (crossLine > len) {
                        break;
                    }
                    if (crossLine > 0) {
                        if (curi < i) {
                            // [... curi ... i ...]
                            curi += nums[curi];
                        } else if (curi > i) {
                            // [... i ... curi ...]
                            // actually do not need this step
                            // this will miss the chance of stop in advance
                            break;
                        } else {
                            // curi == i
                            return true;
                        }
                    } else {
                        curi += nums[curi];
                    }
                    // adjust curi to [0, len - 1]
                    if (curi >= len) {
                        curi %= len;
                        crossLine += 1;
                    }
                }
            } else {
                int curi = i;
                int crossLine = 0;
                while (nums[curi] < 0 && nums[curi] % len != 0) {
                    if (crossLine > len) {
                        break;
                    }
                    if (crossLine > 0) {
                        if (curi < i) {
                            break;
                        } else if (curi > i) {
                            curi += nums[curi];
                        } else {
                            return true;
                        }
                    } else {
                        curi += nums[curi];
                    }
                    if (curi < 0) {
                        curi = len - (-curi % len);
                        crossLine += 1;
                    }
                }
            }
        }
        return false;
    }

}
