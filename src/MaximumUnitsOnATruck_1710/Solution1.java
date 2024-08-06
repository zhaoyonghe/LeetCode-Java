package MaximumUnitsOnATruck_1710;

import java.util.Arrays;

public class Solution1 {
    // Important constraints:
// 1. 1 <= boxTypes.length <= 1000, 1 <= numberOfBoxes_i, numberOfUnitsPerBox_i <= 1000. (No integer overflow.)
// 2. 1 <= truckSize <= 10 ^ 6. (No need to consider truckSize <= 0.)
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int sum = 0;
        for (int[] t : boxTypes) {
            if (truckSize == 0) {
                break;
            }
            int canLoad = Math.min(truckSize, t[0]);
            truckSize -= canLoad;
            sum += canLoad * t[1];

        }
        return sum;
    }
}