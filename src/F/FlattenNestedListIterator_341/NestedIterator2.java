package F.FlattenNestedListIterator_341;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * Assume the nested depth is n.
 * Constructor Time Complexity: O(n)
 * next() Amortized Time Complexity: O(1)
 * hasNext() Time Complexity: O(1)
 * Auxiliary Space Complexity: O(n)
 * Runtime: 5ms
 * Rank: 47.35%
 */
public class NestedIterator2 implements Iterator<Integer> {
    Integer next = null;
    private final Deque<List<NestedInteger>> listSt = new ArrayDeque<>();
    private final Deque<Integer> intSt = new ArrayDeque<>();

    public NestedIterator2(List<NestedInteger> nestedList) {
        listSt.push(nestedList);
        intSt.add(0);
        go();
    }

    private void go() {
        while (!listSt.isEmpty()) {
            List<NestedInteger> curLi = listSt.peek();
            int i = intSt.peek();
            if (i >= curLi.size()) {
                listSt.pop();
                intSt.pop();
                if (intSt.isEmpty()) {
                    next = null;
                    break;
                }
                intSt.push(intSt.pop() + 1);
                continue;
            }
            // i < curLi.size()
            NestedInteger ni = curLi.get(i);
            if (ni.isInteger()) {
                next = ni.getInteger();
                break;
            }
            // ni is a list
            listSt.push(ni.getList());
            intSt.push(0);
        }
    }

    @Override
    public Integer next() {
        int res = next;
        intSt.push(intSt.pop() + 1);
        go();
        return res;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}