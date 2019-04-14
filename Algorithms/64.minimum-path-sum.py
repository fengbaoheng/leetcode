#
# @lc app=leetcode.cn id=64 lang=python3
#
# [64] 最小路径和
#
# https://leetcode-cn.com/problems/minimum-path-sum/description/
#
# algorithms
# Medium (59.57%)
# Total Accepted:    13.2K
# Total Submissions: 22.1K
# Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
#
# 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
#
# 说明：每次只能向下或者向右移动一步。
#
# 示例:
#
# 输入:
# [
# [1,3,1],
# ⁠ [1,5,1],
# ⁠ [4,2,1]
# ]
# 输出: 7
# 解释: 因为路径 1→3→1→1→1 的总和最小。
#
#
#
class Solution:
    # 动态规划,每次计算上方和左方的值,取最小
    def minPathSum(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0

        row = len(grid)
        if row == 0:
            return 0

        col = len(grid[0])
        if col == 0:
            return 0

        # 初始化第1行和第1列,因其只能从左侧和上侧移动
        for r in range(1, row):
            grid[r][0] += grid[r - 1][0]

        for c in range(1, col):
            grid[0][c] += grid[0][c - 1]

        # 逐个扫描
        for r in range(1, row):
            for c in range(1, col):
                grid[r][c] += min(grid[r - 1][c], grid[r][c - 1])

        return grid[row - 1][col - 1]
