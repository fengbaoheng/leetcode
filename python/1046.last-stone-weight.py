#
# @lc app=leetcode.cn id=1046 lang=python3
#
# [1046] 最后一块石头的重量
#
from typing import List
import heapq

class Solution:
    # 使用堆
    def lastStoneWeight(self, stones: List[int]) -> int:
        stones = list(map(lambda x: -x, stones))
        heapq.heapify(stones)

        while len(stones) > 1:
            s1 = heapq.heappop(stones)
            s2 = heapq.heappop(stones)
            ds = abs(s1-s2)
            if ds != 0:
                heapq.heappush(stones, -ds)
        
        if len(stones) == 0:
            return 0
        else:
            return -stones[0]
