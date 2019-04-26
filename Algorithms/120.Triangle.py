#
# @lc app=leetcode.cn id=120 lang=python3
#
# [120] 三角形最小路径和
#
from typing import List


class Solution:
    # 一行一行向下叠加（也可向上叠加）
    # 将累加的路径和填入下一行中
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        try:
            row_count = len(triangle)
            if row_count == 0:
                return 0

            for r in range(1, row_count):
                pre_row = triangle[r-1]
                cur_row = triangle[r]

                col_count = len(cur_row)

                # 每一行的左右两边界只能由上一行的两边界抵达
                cur_row[0] += pre_row[0]
                cur_row[-1] += pre_row[-1]

                for c in range(1, col_count-1):
                    cur_row[c] += min(pre_row[c-1], pre_row[c])

            return min(triangle[-1])

        except:
            return 0
