package DesignHitCounter_362;

import java.util.ArrayList;
import java.util.List;

/**
 * Assume max timestamp is n.
 * Constructor Time Complexity: O(1)
 * hit() Time Complexity: O(1)
 * getHits() Time Complexity: O(log(n))
 * Space Complexity: O(n)
 * Runtime: 1ms
 * Rank: 98.78%
 */
public class HitCounter1 {
    // Important constraints:
    // 1. All the calls are being made to the system in chronological order.
    private final List<int[]> li = new ArrayList<>();

    public HitCounter1() {

    }

    public void hit(int timestamp) {
        if (li.size() == 0) {
            li.add(new int[]{timestamp, 1});
            return;
        }
        int[] last = li.get(li.size() - 1);
        if (last[0] == timestamp) {
            last[1]++;
            return;
        }
        li.add(new int[]{timestamp, 1});
    }

    public int getHits(int timestamp) {
        int to = greatestSmaller(timestamp);
        if (to == -1) {
            return 0;
        }
        int from = smallestGreater(timestamp - 299);
        if (from == -1) {
            return 0;
        }
        int res = 0;
        for (int i = from; i <= to; i++) {
            res += li.get(i)[1];
        }
        return res;
    }

    private int smallestGreater(int num) {
        int start = 0;
        int end = li.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (li.get(mid)[0] < num) {
                start = mid + 1;
            } else if (li.get(mid)[0] > num) {
                if (mid - 1 >= 0 && li.get(mid - 1)[0] >= num) {
                    end = mid - 1;
                    continue;
                }
                return mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int greatestSmaller(int num) {
        int start = 0;
        int end = li.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (li.get(mid)[0] < num) {
                if (mid + 1 < li.size() && li.get(mid + 1)[0] <= num) {
                    start = mid + 1;
                    continue;
                }
                return mid;
            } else if (li.get(mid)[0] > num) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}