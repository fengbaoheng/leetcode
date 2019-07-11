#
# @lc app=leetcode.cn id=746 lang=python3
#
# [746] 使用最小花费爬楼梯
#
from typing import List


class Solution:
    # 动态规划
    # 题意有些模糊, 若cost长度为n,则爬到顶层即爬到n+1层
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        length = len(cost)
        for i in range(2, length):
            cost[i] += min(cost[i - 1], cost[i - 2])

        return min(cost[-1], cost[-2])
