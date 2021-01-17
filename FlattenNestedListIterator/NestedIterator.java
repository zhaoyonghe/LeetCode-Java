package FlattenNestedListIterator;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Assume the nested depth is n.
 * Constructor Time Complexity: O(1)
 * next() Best Time Complexity: O(1)
 * next() Worst Time Complexity: O(n)
 * hasNext() Time Complexity: O(1)
 * goToNext() Best Time Complexity: O(1)
 * goToNext() Worst Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 11ms
 * Rank: 22.74%
 */

public class NestedIterator implements Iterator<Integer> {

    public Deque<List<NestedInteger>> nestedIntegerListStack = new LinkedList<>();
    public Deque<Integer> indexStack = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        nestedIntegerListStack.push(nestedList);
        indexStack.push(0);
        goToNext();
    }

    @Override
    public Integer next() {
        int index = indexStack.pop();
        Integer res = nestedIntegerListStack.peek().get(index).getInteger();
        indexStack.push(index + 1);
        // System.out.println(res);
        goToNext();
        return res;
    }

    @Override
    public boolean hasNext() {
        return !nestedIntegerListStack.isEmpty();
    }

    public void goToNext() {
        while (true) {
            List<NestedInteger> curList = nestedIntegerListStack.peek();
            int curIndex = indexStack.peek();
            if (curIndex >= curList.size()) {
                // out of the range of curList
                // go to the upper layer
                nestedIntegerListStack.pop();
                indexStack.pop();
                if (nestedIntegerListStack.isEmpty()) {
                    return;
                }
                indexStack.push(indexStack.pop() + 1);
            } else {
                NestedInteger nestedInteger = curList.get(curIndex);
                //
                if (nestedInteger.isInteger()) {
                    return;
                } else {
                    // go to the lower layer
                    nestedIntegerListStack.push(nestedInteger.getList());
                    indexStack.push(0);
                }
            }
        }

    }
}
