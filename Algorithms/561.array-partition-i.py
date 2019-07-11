#
# @lc app=leetcode.cn id=561 lang=python3
#
# [561] 数组拆分 I
#
from typing import List


class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        nums.sort()

        result = 0
        for i in range(len(nums)):
            if i % 2 == 0:
                result += nums[i]
            else:
                continue
        return result
