#
# @lc app=leetcode.cn id=304 lang=python3
#
# [304] 二维区域和检索 - 矩阵不可变
#
from typing import List


class NumMatrix:
    # 抽象成计算某个矩形的面积, 使用大矩形减去若干小矩形
    # 为了快速计算, 缓存一个累积矩阵SM
    # SM[i][i] = sumRegion(0,0,i,i)
    # 则sumRegion(r1, c1, r2, c2) = SM[r2][c2] - SM[r2][c1-1] - SM[r1-1][c2] + SM[r1-1][c1-1]
    def __init__(self, matrix: List[List[int]]):
        self.SM = []
        rows = len(matrix)
        if rows == 0:
            return

        cols = len(matrix[0])
        if cols == 0:
            return

        if rows == 0 or cols == 0:
            return

        for r in range(rows):
            self.SM.append(matrix[r][:])
            for c in range(cols):
                left = self.SM[r][c - 1] if c > 0 else 0
                up = self.SM[r - 1][c] if r > 0 else 0
                left_up = self.SM[r - 1][c - 1] if r > 0 and c > 0 else 0

                self.SM[r][c] += left + up - left_up

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        cur = self.SM[row2][col2]
        left = self.SM[row2][col1 - 1] if col1 > 0 else 0
        up = self.SM[row1 - 1][col2] if row1 > 0 else 0
        left_up = self.SM[row1 - 1][col1 - 1] if row1 > 0 and col1 > 0 else 0

        return cur - left - up + left_up
