#
# @lc app=leetcode.cn id=63 lang=python3
#
# [63] 不同路径 II
#
# https://leetcode-cn.com/problems/unique-paths-ii/description/
#
# algorithms
# Medium (30.82%)
# Total Accepted:    9.4K
# Total Submissions: 30.6K
# Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
#
# 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
# 
# 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
# 
# 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
# 
# 
# 
# 网格中的障碍物和空位置分别用 1 和 0 来表示。
# 
# 说明：m 和 n 的值均不超过 100。
# 
# 示例 1:
# 
# 输入:
# [
# [0,0,0],
# [0,1,0],
# [0,0,0]
# ]
# 输出: 2
# 解释:
# 3x3 网格的正中间有一个障碍物。
# 从左上角到右下角一共有 2 条不同的路径：
# 1. 向右 -> 向右 -> 向下 -> 向下
# 2. 向下 -> 向下 -> 向右 -> 向右
# 
# 
#
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        # 排除空矩阵
        row_count = len(obstacleGrid)
        if row_count == 0:
            return 0
        
        col_count = len(obstacleGrid[0])
        if col_count == 0:
            return 0

        # 动态规划矩阵
        dp = [[0 for j in range(col_count)] for i in range(row_count)]
        dp[0][0] = 1 if obstacleGrid[0][0] == 0 else 0

        # 第一行, 只能从左往右走
        for col in range(1, col_count):
            if dp[0][col-1] != 0 and obstacleGrid[0][col] != 1:
                dp[0][col] = dp[0][col-1]

        # 第一列,只能从上往下走
        for row in range(1, row_count):
            if dp[row-1][0] != 0 and obstacleGrid[row][0] != 1:
                dp[row][0] = dp[row-1][0]

        # 中间位置,可以从其上方和左方到达
        # 因此方案数目为二者之和
        for row in range(1, row_count):
            for col in range(1, col_count):
                if obstacleGrid[row][col] == 1:
                    dp[row][col] = 0
                else:
                    dp[row][col] = dp[row-1][col] + dp[row][col-1]
        
        return dp[-1][-1]


