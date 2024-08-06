package RobotRoomCleaner;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Assume n is the number of the available girds.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 6ms
 * Rank: 93.44%
 */
public class Solution1 {
    private final int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private final HashMap<Integer, HashSet<Integer>> visited = new HashMap<>();

    private void dfs(int x, int y, int d, Robot robot) {
        visited.putIfAbsent(x, new HashSet<Integer>());
        visited.get(x).add(y);
        robot.clean();

        for (int i = 0; i < 4; i++) {
            int nd = (d + i) % 4;
            int nx = x + dir[nd][0];
            int ny = y + dir[nd][1];

            if ((!visited.containsKey(nx) || !visited.get(nx).contains(ny)) && robot.move()) {
                dfs(nx, ny, nd, robot);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }

            robot.turnRight();
        }
    }

    public void cleanRoom(Robot robot) {
        dfs(0, 0, 0, robot);
    }
}
