#
# @lc app=leetcode.cn id=463 lang=python3
#
# [463] 岛屿的周长
#
# https://leetcode-cn.com/problems/island-perimeter/description/
#
# algorithms
# Easy (59.76%)
# Total Accepted:    5.4K
# Total Submissions: 9K
# Testcase Example:  '[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]'
#
# 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
#
# 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
#
# 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100
# 。计算这个岛屿的周长。
#
#
#
# 示例 :
#
# 输入:
# [[0,1,0,0],
# ⁠[1,1,1,0],
# ⁠[0,1,0,0],
# ⁠[1,1,0,0]]
#
# 输出: 16
#
# 解释: 它的周长是下面图片中的 16 个黄色的边：
#
#
#
#
#

from typing import List


class Solution:
    # 仅需识别每个岛屿周围四个边的水域或边界数目
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        try:
            row_count = len(grid)
            col_count = len(grid[0])

            count = 0
            for r in range(row_count):
                for c in range(col_count):
                    if grid[r][c] == 1:
                        up = 1 if r == 0 or grid[r - 1][c] == 0 else 0
                        down = 1 if r == row_count - 1 or grid[r + 1][c] == 0 else 0
                        left = 1 if c == 0 or grid[r][c - 1] == 0 else 0
                        right = 1 if c == col_count - 1 or grid[r][c + 1] == 0 else 0
                        count += up + down + left + right
            return count
        except:
            return 0

