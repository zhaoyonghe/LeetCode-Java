package M.MinimumNumberOfRefuelingStops_871;

import java.util.HashMap;
import java.util.Map;

/**
 * Assume stations.length is n.
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(n ^ 2)
 * Runtime: 379ms
 * Rank: 5.02%
 */
public class Solution1 {
    // Important constraints:
    // 1. 1 <= target, startFuel <= 10^9, 1 <= fuel_i < 10^9 (those values are positive)
    // 2. 0 <= stations.length <= 500 (solution will not cost too much memory)
    // 3. 0 <= position_i <= position_i+1 < target (positions are sorted and positive)

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        if (n == 0) {
            return target <= startFuel ? 0 : -1;
        }

        // number of refueling stops until now -> fuel left
        Map<Integer, Integer> prev = new HashMap<>();
        prev.put(0, startFuel);
        for (int i = 0; i < n; i++) {
            prev = fill(prev, stations[i][1], stations[i][0] - (i == 0 ? 0 : stations[i - 1][0]));
            if (prev.size() == 0) {
                return -1;
            }
        }
        return prev.entrySet().stream().filter(e -> stations[n - 1][0] + e.getValue() >= target).mapToInt(e -> e.getKey()).min().orElse(-1);
    }

    private Map<Integer, Integer> fill(Map<Integer, Integer> prev, int fuelInStation, int distanceFromLastStation) {
        Map<Integer, Integer> now = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : prev.entrySet()) {
            int times = entry.getKey();
            int fuelLeft = entry.getValue();

            if (fuelLeft < distanceFromLastStation) {
                continue;
            }
            // Do not fuel at this station.
            putIfBigger(now, times, fuelLeft - distanceFromLastStation);
            // Fuel at this station.
            putIfBigger(now, times + 1, fuelLeft - distanceFromLastStation + fuelInStation);
        }
        return now;
    }

    private void putIfBigger(Map<Integer, Integer> m, int key, int value) {
        int prevVal = m.getOrDefault(key, 0);
        if (prevVal < value) {
            m.put(key, value);
        }
    }
}