#
# @lc app=leetcode.cn id=59 lang=python3
#
# [59] 螺旋矩阵 II
#
# https://leetcode-cn.com/problems/spiral-matrix-ii/description/
#
# algorithms
# Medium (71.85%)
# Total Accepted:    8.3K
# Total Submissions: 11.6K
# Testcase Example:  '3'
#
# 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
#
# 示例:
#
# 输入: 3
# 输出:
# [
# ⁠[ 1, 2, 3 ],
# ⁠[ 8, 9, 4 ],
# ⁠[ 7, 6, 5 ]
# ]
#
#
from typing import List
from enum import Enum


class Direction(Enum):
    Right = 1
    Down = 2
    Left = 3
    Up = 4


class Solution:
    # 一层一层赋值
    def generateMatrix(self, n: int) -> List[List[int]]:

        matrix = [[-1 for j in range(n)] for i in range(n)]

        direction = Direction.Right
        num, end_num = 1, n * n
        row, col = 0, 0

        while num <= end_num:
            matrix[row][col] = num

            num += 1

            # 根据移动方向变换坐标
            # 转换方向: 1.到达边界 2.下一个矩阵位置值不为-1
            if direction == Direction.Right:
                if col == n - 1 or matrix[row][col+1] != -1:
                    row += 1
                    direction = Direction.Down
                else:
                    col += 1
            elif direction == Direction.Down:
                if row == n - 1 or matrix[row+1][col]!= -1:
                    col -= 1
                    direction = Direction.Left
                else:
                    row += 1
            elif direction == Direction.Left:
                if col == 0 or matrix[row][col-1]!= -1:
                    row -= 1
                    direction = Direction.Up
                else:
                    col -= 1
            elif direction == Direction.Up:
                if row == 0 or matrix[row-1][col]!= -1:
                    col += 1
                    direction = Direction.Right
                else:
                    row -= 1
        
        return matrix

if __name__ == "__main__":
    print(Solution().generateMatrix(2))

