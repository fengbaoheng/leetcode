/*
 * @lc app=leetcode.cn id=1041 lang=java
 *
 * [1041] 困于环中的机器人
 */

// @lc code=start
class Solution {
    public boolean isRobotBounded(String instructions) {
        Robot robot = new Robot();

        for (int i = 0; i < 4; i++) {
            robot.run(instructions);
            if (robot.isBounded()) {
                return true;
            }
        }

        return false;
    }

    private static class Robot {
        private final int N = 0, E = 1, S = 2, W = 3;
        private int x = 0, y = 0;
        private int d = N;

        public boolean isBounded() {
            return x == 0 && y == 0 && d == N;
        }

        public void run(String str) {
            for (char c : str.toCharArray()) {
                run(c);
            }
        }

        public void run(char c) {
            switch (c) {
                case 'G':
                    go();
                    break;
                case 'L':
                    turnLeft();
                    break;
                case 'R':
                    turnRight();
                    break;
            }
        }

        // 直行
        private void go() {
            switch (d) {
                case N:
                    y++;
                    break;
                case S:
                    y--;
                    break;
                case E:
                    x++;
                    break;
                case W:
                    x--;
                    break;
            }
        }

        // 左转
        private void turnLeft() {
            d += 3;
            d %= 4;
        }

        // 右转
        private void turnRight() {
            d += 1;
            d %= 4;
        }

    }
}
// @lc code=end

