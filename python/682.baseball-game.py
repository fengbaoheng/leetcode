#
# @lc app=leetcode.cn id=682 lang=python3
#
# [682] 棒球比赛
#
import unittest
from typing import List


class Solution:
    # 栈的基本操作
    def calPoints(self, ops: List[str]) -> int:
        stack = []

        for s in ops:
            if s == "+" and len(stack) >= 2:
                stack.append(stack[-1] + stack[-2])
            elif s == "D" and len(stack) >= 1:
                stack.append(stack[-1] * 2)
            elif s == "C" and len(stack) >= 1:
                stack.pop()
            else:
                stack.append(int(s))

        return sum(stack)


if __name__ == "__main__":
    solution = Solution()

    assert 30 == Solution().calPoints(["5", "2", "C", "D", "+"])
    assert 27 == Solution().calPoints(["5", "-2", "4", "C", "D", "9", "+", "+"])

