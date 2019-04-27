#
# @lc app=leetcode.cn id=807 lang=python3
#
# [807] 保持城市天际线
#
from typing import List


class Solution:
    # 保持4个方向=>保持2个方向,因为左右和上下是一样的
    # 保持天际线即新增的楼不能超过当前水平方向和竖直方向最高的楼
    # 即增加后的新高度为 min(max(row), max(col))
    def maxIncreaseKeepingSkyline(self, grid: List[List[int]]) -> int:
        try:
            row_count = len(grid)
            col_count = len(grid[0])

            # 计算各行列的天际线
            max_rows = [max(row) for row in grid]
            max_cols = [max(col) for col in zip(*grid)]

            # 累加差值
            count = 0
            for r in range(row_count):
                for c in range(col_count):
                    count += min(max_rows[r], max_cols[c])  - grid[r][c] 

            return count
        except:
            return 0

if __name__ == "__main__":
    Solution().maxIncreaseKeepingSkyline([[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]])
