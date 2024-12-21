package O.OperationsOnTree_1993;

import java.util.ArrayList;
import java.util.List;

/**
 * $$ Assume the node count of the tree is n.
 * $$ Constructor Time Complexity: O(n)
 * $$ lock() Time Complexity: O(1)
 * $$ unlock() Time Complexity: O(1)
 * $$ upgrade() Time Complexity: O(n)
 */
class LockingTree1 {
    private final List<List<Integer>> ancestors = new ArrayList<>();
    private final List<List<Integer>> descendants = new ArrayList<>();
    private final int[] lockedBy;

    public LockingTree1(int[] parent) {
        this.lockedBy = new int[parent.length];
        for (int node = 0; node < parent.length; node++) {
            this.ancestors.add(new ArrayList<>());
            this.descendants.add(new ArrayList<>());
        }
        for (int node = 0; node < parent.length; node++) {
            put(parent, node);
        }
        // for (int node = 0; node < parent.length; node++) {
        //     System.out.printf("anc: %d: %s\n", node, this.ancestors.get(node));
        // }
        // for (int node = 0; node < parent.length; node++) {
        //     System.out.printf("des: %d: %s\n", node, this.descendants.get(node));
        // }
    }

    private void put(int[] parent, int node) {
        int ancestor = parent[node];
        while (ancestor != -1) {
            this.ancestors.get(node).add(ancestor);
            this.descendants.get(ancestor).add(node);
            ancestor = parent[ancestor];
        }
    }

    public boolean lock(int num, int user) {
        if (this.lockedBy[num] == 0) {
            this.lockedBy[num] = user;
            return true;
        }
        return false;
    }

    public boolean unlock(int num, int user) {
        if (this.lockedBy[num] == user) {
            this.lockedBy[num] = 0;
            return true;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        if (this.lockedBy[num] > 0) {
            return false;
        }
        if (!haveLockedDescendant(num)) {
            return false;
        }
        if (haveLockedAncestor(num)) {
            return false;
        }
        for (int des : this.descendants.get(num)) {
            this.lockedBy[des] = 0;
        }
        this.lockedBy[num] = user;
        return true;
    }

    private boolean haveLockedAncestor(int num) {
        for (int anc : this.ancestors.get(num)) {
            if (this.lockedBy[anc] > 0) {
                return true;
            }
        }
        return false;
    }

    private boolean haveLockedDescendant(int num) {
        for (int des : this.descendants.get(num)) {
            if (this.lockedBy[des] > 0) {
                return true;
            }
        }
        return false;
    }
}