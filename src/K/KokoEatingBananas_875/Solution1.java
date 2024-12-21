package K.KokoEatingBananas_875;

/**
 * $$ Assume piles.length is n.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public int minEatingSpeed(int[] piles, int h) {
        int s = 1;
        int e = max(piles);
        while (s <= e) {
            int m = (s + e) / 2;
            int hrs = hours(piles, m);
            //System.out.printf("m: %d, hrs: %d\n", m, hrs);
            if (hrs > h) {
                s = m + 1;
            } else {
                // hrs <= h
                if (m > 1 && hours(piles, m - 1) <= h) {
                    e = m - 1;
                    continue;
                }
                return m;
            }
        }
        return -1;
    }

    private int hours(int[] piles, int speed) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile / speed + (pile % speed == 0 ? 0 : 1));
        }
        return hours;
    }

    private int max(int[] piles) {
        int m = 0;
        for (int pile : piles) {
            m = Math.max(m, pile);
        }
        return m;
    }
}