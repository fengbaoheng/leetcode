#
# @lc app=leetcode.cn id=200 lang=python3
#
# [200] 岛屿的个数
#
from typing import List


class Solution:
    # 发现岛屿后,广度优先搜索附近的1
    def numIslands(self, grid: List[List[str]]) -> int:
        try:
            if not grid:
                return 0

            rows = len(grid)
            if rows == 0:
                return 0

            cols = len(grid[0])
            if cols == 0:
                return 0

            count = 0
            stack = []
            for r in range(rows):
                for c in range(cols):
                    if grid[r][c] == "0":
                        continue

                    count += 1
                    # 发现一个岛屿后就搜索附近的方格
                    stack.append((r, c))
                    while stack:
                        ri, ci = stack.pop()
                        # 可能已经置零过了
                        if grid[ri][ci] == "0":
                            continue
                        grid[ri][ci] = "0"

                        # 左
                        if ci > 0 and grid[ri][ci - 1] == "1":
                            stack.append((ri, ci - 1))
                        # 右
                        if ci < cols - 1 and grid[ri][ci + 1] == "1":
                            stack.append((ri, ci + 1))
                        # 上
                        if ri > 0 and grid[ri - 1][ci] == "1":
                            stack.append((ri - 1, ci))
                        # 下
                        if ri < rows - 1 and grid[ri + 1][ci] == "1":
                            stack.append((ri + 1, ci))
            return count
        except Exception as e:
            raise e

