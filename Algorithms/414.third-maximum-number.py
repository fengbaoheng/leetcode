#
# @lc app=leetcode.cn id=414 lang=python3
#
# [414] 第三大的数
#
from typing import List


class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        length = len(nums)
        if length == 0:
            return -1

        inf = float("-inf")
        max_num = [inf, inf, inf]
        for n in nums:
            if n <= max_num[2] or n in max_num:
                continue
            elif n < max_num[1]:
                max_num[2] = n
            elif n < max_num[0]:
                max_num[2] = max_num[1]
                max_num[1] = n
            else:
                max_num[2] = max_num[1]
                max_num[1] = max_num[0]
                max_num[0] = n

        if max_num[3] == inf:
            return max_num[0]
        else:
            return max_num[3]
