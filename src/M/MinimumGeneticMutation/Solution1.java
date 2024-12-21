package M.MinimumGeneticMutation;

import java.util.*;

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 77.61%
 */


public class Solution1 {

    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }

        Set<String> valid = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Deque<String> q = new ArrayDeque<>();
        char[] a = new char[]{'A', 'T', 'C', 'G'};

        Collections.addAll(valid, bank);

        if (!valid.contains(end)) {
            return -1;
        }

        q.offer(start);
        visited.add(start);
        int count = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int ii = 0; ii < sz; ii++) {
                char[] gene = q.poll().toCharArray();
                for (int i = 0; i < 8; i++) {
                    // find the gene type
                    int j = 0;
                    for (; j < 4; j++) {
                        if (gene[i] == a[j]) {
                            break;
                        }
                    }

                    for (int k = 1; k < 4; k++) {
                        j = (j + 1) % 4;
                        gene[i] = a[j];
                        String mgene = new String(gene);
                        // System.out.println(mgene);
                        if (mgene.equals(end)) {
                            return count + 1;
                        }
                        if (valid.contains(mgene) && !visited.contains(mgene)) {
                            visited.add(mgene);
                            q.offer(mgene);
                        }
                    }

                    // set back
                    j = (j + 1) % 4;
                    gene[i] = a[j];
                }
            }
            count += 1;
        }

        return -1;

    }

}
