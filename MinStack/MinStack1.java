package MinStack;

/**
 * Time Complexity: O()
 * Space Complexity: O(1)
 * Runtime: 70ms
 * Rank: 99.68%
 */
public class MinStack1 {
    // Maintain two stacks.
    // One is the normal stack, 
    // the other records the indices of min numbers in the history. 
    int stacktop = -1;
    int fullsize = 8;
    int[] stack = null;
    int minstacktop = -1;
    int minfullsize = 8;
    int[] minstack = null;
    int min = Integer.MAX_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack1() {
        stack = new int[8];
        minstack = new int[8];
    }

    public void push(int x) {
        if (stacktop == fullsize - 1) {
            int[] tempstack = new int[fullsize << 1];
            for (int i = 0; i < fullsize; i++) {
                tempstack[i] = stack[i];
            }
            fullsize <<= 1;
            stack = tempstack;
        }
        stacktop++;
        stack[stacktop] = x;
        if (x < min) {
            if (minstacktop == minfullsize - 1) {
                int[] tempstack = new int[minfullsize << 1];
                for (int i = 0; i < minfullsize; i++) {
                    tempstack[i] = minstack[i];
                }
                minfullsize <<= 1;
                minstack = tempstack;
            }
            minstacktop++;
            minstack[minstacktop] = stacktop;
            min = x;
        }
    }

    public void pop() {
        if (stacktop != -1) {
            if (stacktop == minstack[minstacktop]) {
                minstacktop--;
                if (minstacktop != -1) {
                    min = stack[minstack[minstacktop]];
                } else {
                    min = Integer.MAX_VALUE;
                }

            }
            stacktop--;
        }
    }

    public int top() {
        if (stacktop != -1) {
            return stack[stacktop];
        } else {
            return -1;
        }
    }

    public int getMin() {
        return min;
    }

}
