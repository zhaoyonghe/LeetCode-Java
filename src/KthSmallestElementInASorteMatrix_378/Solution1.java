package KthSmallestElementInASorteMatrix_378;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] idx = new int[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return Integer.compare(matrix[a][idx[a]], matrix[b][idx[b]]);
            }
        });

        for (int i = 0; i < n; i++) {
            pq.add(i);
        }
        for (int i = 0; i < n; i++) {
            idx[i]++;
        }

        for (int i = 0; i < k; i++) {
            int res = pq.poll();
            if (i + 1 == k) {
                return res;
            }
            idx[res]++;
            if (res < n) {
                pq.add(res);
            }
        }

        return 888;
    }
}
