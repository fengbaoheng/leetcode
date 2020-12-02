#
# @lc app=leetcode.cn id=240 lang=python3
#
# [240] 搜索二维矩阵 II
#
from typing import List


class Solution:
    # 剑指offer题目
    # 从右上角开始，向左下方搜索
    # 每次可以减少一行或一列的搜索范围
    # 若从常规的左上角开始搜索，则搜索区域无法排除彻底
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        try:
            row_count = len(matrix)
            col_count = len(matrix[0])

            if target < matrix[0][0] or target > matrix[-1][-1]:
                return False

            # 行递增（向下搜索）
            # 列递减（向左搜索）
            r, c = 0, col_count-1
            while r < row_count and c >= 0:
                m = matrix[r][c]
                if m == target:
                    return True
                elif m < target:
                    r += 1
                else:
                    c -= 1

            return False

        except:
            return False


if __name__ == "__main__":
    solution = Solution()
    matrix = [
        [1,   4,  7, 11, 15],
        [2,   5,  8, 12, 19],
        [3,   6,  9, 16, 22],
        [10, 13, 14, 17, 24],
        [18, 21, 23, 26, 30]
    ]

    assert solution.searchMatrix(matrix, 5) == True
    assert solution.searchMatrix(matrix, 20) == False
    print("Finish")
