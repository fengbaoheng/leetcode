#
# @lc app=leetcode.cn id=704 lang=python3
#
# [704] 二分查找
#
from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        try:
            p, q = 0, len(nums) - 1

            while p <= q:
                m = (p + q) // 2
                
                if nums[m] < target:
                    p = m + 1
                elif nums[m] > target:
                    q = m - 1
                else:
                    return m

            return -1
        except:
            return -1

