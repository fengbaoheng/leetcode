#
# @lc app=leetcode.cn id=215 lang=python3
#
# [215] 数组中的第K个最大元素
#
from typing import List
import heapq


class Solution:
    # 使用容量为k的大顶堆
    def findKthLargest(self, nums: List[int], k: int) -> int:
        return heapq.nlargest(k, nums)[-1]

