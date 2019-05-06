#
# @lc app=leetcode.cn id=48 lang=python3
#
# [48] 旋转图像
#
from typing import List


class Solution:
    # 原地旋转90度可等效为先竖直翻转再对角线翻转
    def rotate(self, matrix: List[List[int]]) -> None:
        try:
            row_count = len(matrix)
            col_count = len(matrix[0])

            # 竖直翻转
            for r in range(row_count // 2):
                for c in range(col_count):
                    exr = row_count - 1 - r
                    matrix[r][c], matrix[exr][c] = matrix[exr][c], matrix[r][c]

            # 对角线翻转
            for r in range(row_count):
                for c in range(r):
                    matrix[r][c], matrix[c][r] = matrix[c][r], matrix[r][c]

        except Exception as e:
            raise e


if __name__ == "__main__":
    matrix = [[5, 1, 9, 11], [2, 4, 8, 10], [13, 3, 6, 7], [15, 14, 12, 16]]
    solution = Solution()
    solution.rotate(matrix)
    print(matrix)
