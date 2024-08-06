package FlattenNestedListIterator_341;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * Assume the integer count in the list is n.
 * Constructor Time Complexity: O(n)
 * next() Amortized Time Complexity: O(1)
 * hasNext() Time Complexity: O(1)
 * Auxiliary Space Complexity: O(n)
 * Runtime: 5ms
 * Rank: 47.35%
 */
public class NestedIterator3 implements Iterator<Integer> {
    private final Deque<NestedInteger> st = new ArrayDeque<>();

    public NestedIterator3(List<NestedInteger> nestedList) {
        pushAll(nestedList);
        unfoldTop();
    }

    private void unfoldTop() {
        while (!st.isEmpty() && !st.peek().isInteger()) {
            pushAll(st.pop().getList());
        }
    }

    private void pushAll(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            st.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        int res = st.pop().getInteger();
        unfoldTop();
        return res;
    }

    @Override
    public boolean hasNext() {
        return !st.isEmpty();
    }
}