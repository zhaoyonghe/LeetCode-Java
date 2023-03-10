package CircularArrayLoop;

/**
 * Assume n is nums.length.
 * Best Time Complexity: O(n) when return is true
 * Worse Time Complexity: O(n ^ 2) when return is false
 * Space Complexity: O(1)
 * Runtime: 16ms
 * Rank: 31.46%
 */
public class Solution2 {
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                int curi = i;
                int crossLine = 0;
                // int circleLen = 0;
                while (nums[curi] > 0 && nums[curi] % len != 0) {
                    if (crossLine > len) {
                        break;
                    }
                    if (crossLine > 0) {
                        if (curi != i) {
                            curi += nums[curi];
                        } else {
                            return true;
                        }
                    } else {
                        curi += nums[curi];
                    }
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
                        if (curi != i) {
                            break;
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
