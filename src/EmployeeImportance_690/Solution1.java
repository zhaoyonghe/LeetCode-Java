package EmployeeImportance_690;

import java.util.*;

/**
 * Assume the length of employees is n.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 6ms
 * Rank: 80.96%
 */

public class Solution1 {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> id2e = new HashMap<>();
        for (Employee e : employees) {
            id2e.put(e.id, e);
        }
        // bfs in a tree, collect all subordinates of employee id
        int res = 0;
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(id);
        while (!q.isEmpty()) {
            int cur = q.poll();
            Employee curE = id2e.get(cur);
            res += curE.importance;
            for (int sub : curE.subordinates) {
                q.offer(sub);
            }
        }
        return res;
    }
}
