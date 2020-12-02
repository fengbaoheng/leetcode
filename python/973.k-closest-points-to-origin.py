#
# @lc app=leetcode.cn id=973 lang=python3
#
# [973] 最接近原点的 K 个点
#

import heapq
from typing import List

class Solution:
    def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
        try:
            return heapq.nsmallest(K, points, lambda p: p[0]**2 + p[1]**2)
        except:
            return []
        

