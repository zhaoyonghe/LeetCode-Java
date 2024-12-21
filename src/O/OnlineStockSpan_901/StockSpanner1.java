package O.OnlineStockSpan_901;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * $$ Constructor Time Complexity: O(1)
 * $$ next() Amortized Time Complexity: O(1)
 */
class StockSpanner1 {

    Deque<int[]> st = new ArrayDeque<>();
    int day = 0;

    public StockSpanner1() {

    }

    public int next(int price) {
        this.day++;
        while (!this.st.isEmpty() && this.st.peek()[0] <= price) {
            this.st.pop();
        }
        // use monotonic stack
        // stack top is the last price that is higher than today
        if (this.st.isEmpty()) {
            // today's price is the peak price so far
            this.st.push(new int[]{price, this.day});
            return this.day;
        }
        int res = this.day - this.st.peek()[1];
        this.st.push(new int[]{price, this.day});
        return res;
    }
}