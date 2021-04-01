/*
 * @lc app=leetcode.cn id=874 lang=java
 *
 * [874] 模拟行走机器人
 */

// @lc code=start
import java.util.*;

class Solution {

    public int robotSim(int[] commands, int[][] obstacles) {
        Obstacle obstacle = new Obstacle(obstacles);
        Robot robot = new Robot(obstacle);

        for (int command : commands) {
            robot.run(command);
        }

        return robot.maxDistance;
    }


    private static class Robot {
        // 北 东 南 西
        private static final int[][] DIRECTION = new int[][]{
                {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };

        private int x, y;
        private int d;
        private int maxDistance;

        private final Obstacle obstacle;

        public Robot(Obstacle obstacle) {
            this.obstacle = obstacle;
        }

        private void run(int command) {
            switch (command) {
                case -1:
                    turnRight();
                    break;
                case -2:
                    turnLeft();
                    break;
                default:
                    move(command);
                    break;
            }
        }


        private void turnLeft() {
            d = (d + 3) % 4;
        }

        private void turnRight() {
            d = (d + 1) % 4;
        }

        private void move(int steps) {
            int dx = DIRECTION[d][0];
            int dy = DIRECTION[d][1];

            int nx = 0, ny = 0;
            for (int i = 0; i < steps; i++) {
                nx = x + dx;
                ny = y + dy;

                if (!obstacle.canMove(nx, ny)) {
                    break;
                }
                x = nx;
                y = ny;
            }

            // 更新最大距离
            maxDistance = Math.max(maxDistance, getDistance());

        }

        // 欧式距离平方
        private int getDistance() {
            return x * x + y * y;
        }
    }


    private static class Obstacle {
        private Map<Integer, Set<Integer>> map = new HashMap<>();

        Obstacle(int[][] obstacles) {
            for (int[] obstacle : obstacles) {
                int x = obstacle[0];
                int y = obstacle[1];

                map.putIfAbsent(x, new HashSet<>());
                map.get(x).add(y);
            }
        }

        // 给定坐标是否有障碍物
        private boolean canMove(int x, int y) {
            if (!map.containsKey(x)) {
                return true;
            }

            return !map.get(x).contains(y);
        }
    }
}
// @lc code=end

