package T.TheSkylineProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * Assume n is the number of buildings.
 * Time Complexity: O(2nlog2n)
 * Space Complexity: O(2n)
 * Runtime: 87ms
 * Rank: 70.63%
 */
public class Solution1 {
    public List<int[]> getSkyline(int[][] buildings) {
        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length * 2];
        for (int i = 0; i < buildings.length; i++) {
            buildingPoints[i * 2] = new BuildingPoint(buildings[i][0], buildings[i][2], 's');
            buildingPoints[i * 2 + 1] = new BuildingPoint(buildings[i][1], buildings[i][2], 'e');
        }
        Arrays.sort(buildingPoints);
        System.out.println(Arrays.toString(buildingPoints));
        List<int[]> result = new ArrayList<>();
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        tm.put(0, 1);
        int prevMaxHeight = 0;
        for (BuildingPoint bp : buildingPoints) {
            if (bp.type == 's') {
                tm.compute(bp.height, (key, value) -> {
                    if (value == null) {
                        return 1;
                    } else {
                        return value + 1;
                    }
                });
            } else {
                // bp.type == 'e'
                tm.compute(bp.height, (key, value) -> {
                    if (value == 1) {
                        return null;
                    } else {
                        return value - 1;
                    }
                });
            }
            int curMaxHeight = tm.lastKey();
            if (prevMaxHeight != curMaxHeight) {
                result.add(new int[]{bp.x, curMaxHeight});
                prevMaxHeight = curMaxHeight;
            }
        }
        return result;
    }

    public class BuildingPoint implements Comparable<BuildingPoint> {
        public int x;
        public int height;
        public char type;

        public BuildingPoint(int x, int height, char type) {
            super();
            this.x = x;
            this.height = height;
            this.type = type;
        }

        @Override
        public int compareTo(BuildingPoint bp) {
            if (this.x == bp.x) {
                if (this.type == 's' && bp.type == 's') {
                    return bp.height - this.height;
                } else if (this.type == 'e' && bp.type == 'e') {
                    return this.height - bp.height;
                } else {
                    if (this.type == 's') {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            } else {
                return this.x - bp.x;
            }
        }

        @Override
        public String toString() {
            return "BuildingPoint [x=" + x + ", height=" + height + ", type=" + type + "]";
        }

    }

}
