#
# @lc app=leetcode.cn id=961 lang=python3
#
# [961] 重复 N 次的元素
#
from typing import List


class Solution:
    def repeatedNTimes(self, A: List[int]) -> int:
        try:
            s = set([])

            for num in A:
                if num in s:
                    return num
                else:
                    s.add(num)

        except Exception as e:
            raise e

