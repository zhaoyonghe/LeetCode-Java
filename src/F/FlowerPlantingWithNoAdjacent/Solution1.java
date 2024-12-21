package F.FlowerPlantingWithNoAdjacent;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * Runtime: 26ms
 * Rank: 86.19%
 */
public class Solution1 {
    public int[] gardenNoAdj(int N, int[][] paths) {
        int[] result = new int[N];

        // initialize the adjacent list
        List<List<Integer>> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            list.add(null);
        }

        // construct the adjacent list
        for (int[] edge : paths) {
            if (list.get(edge[0] - 1) == null) {
                List<Integer> temp = new ArrayList<>();
                temp.add(edge[1] - 1);
                list.set(edge[0] - 1, temp);
            } else {
                list.get(edge[0] - 1).add(edge[1] - 1);
            }
            if (list.get(edge[1] - 1) == null) {
                List<Integer> temp = new ArrayList<>();
                temp.add(edge[0] - 1);
                list.set(edge[1] - 1, temp);
            } else {
                list.get(edge[1] - 1).add(edge[0] - 1);
            }
        }

        // color the vertices
        for (int i = 0; i < N; i++) {
            int[] color = {1, 2, 3, 4};
            if (list.get(i) != null) {
                for (int j : list.get(i)) {
                    if (result[j] - 1 > -1) {
                        color[result[j] - 1] = 0;
                    }
                }
            }
            for (int j = 0; j < 4; j++) {
                if (color[j] != 0) {
                    result[i] = color[j];
                    break;
                }
            }

        }
        return result;
    }
}
