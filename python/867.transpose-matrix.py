#
# @lc app=leetcode.cn id=867 lang=python3
#
# [867] 转置矩阵
#
from typing import List


class Solution:
    def transpose(self, A: List[List[int]]) -> List[List[int]]:
        if A is None:
            return []

        rows = len(A)
        if rows == 0:
            return []

        cols = len(A[0])
        if cols == 0:
            return []

        B = []

        for c in range(cols):
            B.append([A[r][c] for r in range(rows)])

        return B

