package FlattenNestedListIterator_341;

import java.util.*;
/**
 * Assume the integer count in the list is n.
 * Constructor Time Complexity: O(n)
 * next() Time Complexity: O(1)
 * hasNext() Time Complexity: O(1)
 * Space Complexity: O(n)
 * Runtime: 3ms
 * Rank: 85.53%
 */
public class NestedIterator1 implements Iterator<Integer> {
    private List<Integer> list = new ArrayList<>();
    private Iterator<Integer> it;
    public NestedIterator1(List<NestedInteger> nestedList) {
        collect(nestedList);
        it = list.iterator();
    }

    private void collect(List<NestedInteger> nestedList) {
        for (NestedInteger ni: nestedList) {
            if (ni.isInteger()) {
                list.add(ni.getInteger());
                continue;
            }
            collect(ni.getList());
        }
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
}