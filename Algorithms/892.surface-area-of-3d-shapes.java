/*
 * @lc app=leetcode.cn id=892 lang=java
 *
 * [892] 三维形体的表面积
 */

// @lc code=start
class Solution {
    public int surfaceArea(int[][] grid) {
        int N = grid.length;
        Pillar[][] pillars = new Pillar[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                Pillar pillar = new Pillar(grid[r][c]);
                if (c > 0) {
                    pillar.shelterLeft(pillars[r][c - 1]);
                }
                if (r > 0) {
                    pillar.shelterFront(pillars[r - 1][c]);
                }
                pillars[r][c] = pillar;
            }
        }

        int area = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                area += pillars[r][c].area();
            }
        }
        return area;
    }

    private class Pillar {
        int up, down, front, back, left, right;

        public Pillar(int height) {
            if (height > 0) {
                up = 1;
                down = 1;
                front = height;
                back = height;
                left = height;
                right = height;
            }
        }

        public int area() {
            return up + down + front + back + left + right;
        }

        public void shelterLeft(Pillar leftPillar) {
            if (leftPillar.right >= this.left) {
                leftPillar.right -= this.left;
                this.left = 0;
            } else {
                this.left -= leftPillar.right;
                leftPillar.right = 0;
            }
        }

        public void shelterFront(Pillar frontPillar) {
            if (frontPillar.back >= this.front) {
                frontPillar.back -= this.front;
                this.front = 0;
            } else {
                this.front -= frontPillar.back;
                frontPillar.back = 0;
            }
        }
    }
}
// @lc code=end

