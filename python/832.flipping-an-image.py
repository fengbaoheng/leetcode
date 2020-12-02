#
# @lc app=leetcode.cn id=832 lang=python3
#
# [832] 翻转图像
#
from typing import List


class Solution:
    def flipAndInvertImage(self, A: List[List[int]]) -> List[List[int]]:
        try:
            rows = len(A)
            if rows == 0:
                return []

            cols = len(A[0])
            if cols == 0:
                return []

            matrix = []
            for r in range(rows):
                row = []
                for c in range(cols):
                    num = A[r][cols - 1 - c]
                    num = (num + 1) % 2
                    row.append(num)
                matrix.append(row)
            return matrix
        except Exception as e:
            raise e

