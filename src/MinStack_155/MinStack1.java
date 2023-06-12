package MinStack_155;
import java.util.*;
/**
 * $$ push() Time Complexity: O(1)
 * $$ pop() Time Complexity: O(1)
 * $$ top() Time Complexity: O(1)
 * $$ getMin() Time Complexity: O(1)
 */
public class MinStack1 {
    Deque<Integer> st = new ArrayDeque<>();
    Deque<Integer> minst = new ArrayDeque<>();

    public MinStack1() {

    }

    public void push(int val) {
        st.push(val);
        if (minst.isEmpty() || val <= minst.peek()) {
            minst.push(val);
        }
    }

    public void pop() {
        if ((int)st.peek() == (int)minst.peek()) {
            minst.pop();
        }
        st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minst.peek();
    }
}
