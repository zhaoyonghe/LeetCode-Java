package RobotBoundedInCircle_1041;
/**
 * Time Complexity: O(instructions.length)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 0ms
 * Rank: 100.00%
 */

public class Solution1 {
    public boolean isRobotBounded(String instructions) {
        int[] pos = new int[2];
        int dirsIndex = 0;
        int[][] dirs = new int[][]{
                {0,1},{1,0},{0,-1},{-1,0}
        };
        for (char c: instructions.toCharArray()) {
            switch(c) {
                case 'G':
                    pos[0] += dirs[dirsIndex][0];
                    pos[1] += dirs[dirsIndex][1];
                    break;
                case 'L':
                    dirsIndex = (dirsIndex + 4 - 1) % 4;
                    break;
                case 'R':
                    dirsIndex = (dirsIndex + 4 + 1) % 4;
                    break;
            }
        }
        return dirsIndex != 0 || (pos[0]==0&&pos[1]==0);
    }
}