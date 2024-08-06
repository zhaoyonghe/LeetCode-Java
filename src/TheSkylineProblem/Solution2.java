package TheSkylineProblem;

import java.util.*;

/**
 * Assume n is the number of buildings.
 * Time Complexity: O(2nlog2n)
 * Space Complexity: O(2n)
 * Runtime: 46ms
 * Rank: 77.23%
 */

class Solution2 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> list = new ArrayList<>();

        if (buildings == null || buildings.length == 0) {
            return list;
        }

        Point[] points = new Point[buildings.length * 2];
        for (int i = 0; i < buildings.length; i++) {
            points[i * 2] = new Point(buildings[i][0], buildings[i][2], 's');
            points[i * 2 + 1] = new Point(buildings[i][1], buildings[i][2], 'e');
        }

        Arrays.sort(points);

        // key: height
        // value: times of occurrence of this height
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);

        int maxHeight = 0;

        // add into result when a new highest start comes
        for (Point point : points) {
            if (point.type == 's') {
                // add the height when the corresponding building starts
                if (map.containsKey(point.height)) {
                    Integer t = map.get(point.height);
                    map.put(point.height, t + 1);
                } else {
                    map.put(point.height, 1);
                }

                // add to the result if and only if the max height changes
                Map.Entry<Integer, Integer> entry = map.lastEntry();
                if (entry.getKey() > maxHeight) {
                    maxHeight = entry.getKey();
                    ArrayList<Integer> tempList = new ArrayList<Integer>();
                    tempList.add(point.x);
                    tempList.add(maxHeight);
                    list.add(tempList);
                }
            } else {
                // point.type == 'e'
                Integer t = map.get(point.height);

                // remove the height when the corresponding building ends
                if (t == 1) {
                    map.remove(point.height);

                    // add to the result if and only if the max height changes
                    Map.Entry<Integer, Integer> entry = map.lastEntry();
                    if (entry.getKey() < maxHeight) {
                        maxHeight = entry.getKey();
                        ArrayList<Integer> tempList = new ArrayList<Integer>();
                        tempList.add(point.x);
                        tempList.add(maxHeight);
                        list.add(tempList);
                    }
                } else {
                    map.put(point.height, t - 1);
                }
            }
        }

        return list;
    }

    public class Point implements Comparable<Point> {
        public int x;
        public int height;
        public char type;

        Point(int x, int height, char type) {
            this.x = x;
            this.height = height;
            this.type = type;
        }

        public int compareTo(Point point) {
            if (this.x == point.x) {
                if (this.type == 's' && point.type == 's') {
                    return point.height - this.height;
                } else if (this.type == 'e' && point.type == 'e') {
                    return this.height - point.height;
                } else {
                    return point.type - this.type;
                }
            } else {
                return this.x - point.x;
            }
        }

        public String toString() {
            return "BuildingPoint [x=" + x + ", height=" + height + ", type=" + type + "]";
        }
    }
}