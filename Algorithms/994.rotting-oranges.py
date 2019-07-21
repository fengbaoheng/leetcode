#
# @lc app=leetcode.cn id=994 lang=python3
#
# [994] 腐烂的橘子
#
from typing import List


class Solution:
    # 分成两堆橘子 腐烂的rotten 和 新鲜的fresh
    # 用坐标(x,y)代表橘子
    # rotten中的橘子在下一秒感染附近的橘子后移除(只需判断一次能否感染给其他橘子)
    # 当rotten为空时, 结束计算, 此时fresh若不为空,则永远感染不到返回-1
    # 特殊情况 给定的数据中 没有橘子, 没有腐烂的橘子 全是腐烂的橘子
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid is None or len(grid) == 0 or len(grid[0]) == 0:
            return -1

        rows = len(grid)
        cols = len(grid[0])

        fresh = set([])
        rotten = set([])

        # 分类,记录坐标
        for r in range(rows):
            for c in range(cols):
                value = grid[r][c]
                pos = (r, c)
                if value == 1:
                    fresh.add(pos)
                elif value == 2:
                    rotten.add(pos)

        # 状态结束
        rotten_length = len(rotten)
        fresh_length = len(fresh)

        # 没有橘子 全是腐烂橘子
        if fresh_length == 0:
            return 0
        # 全是新鲜橘子
        elif rotten_length == 0:
            return -1

        # 持续感染
        min = 0
        while len(rotten) > 0:
            # 本轮新被感染腐烂的橘子
            new_rotten = set([])
            for orange in rotten:
                # 搜索周围可被感染的新鲜橘子
                r, c = orange
                nearby = set([(r - 1, c), (r + 1, c), (r, c - 1), (r, c + 1)])
                nearby_fresh = fresh & nearby

                # 将附近的新鲜橘子感染
                # 即移出fresh, 移入new_rotten
                fresh = fresh - nearby_fresh
                new_rotten = new_rotten | nearby_fresh

            rotten = new_rotten
            min += 1

        return min - 1 if len(fresh) == 0 else -1
