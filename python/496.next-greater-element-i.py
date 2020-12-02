#
# @lc app=leetcode.cn id=496 lang=python3
#
# [496] 下一个更大元素 I
#
from typing import List


class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:        
        dict = {}
        stack = []

        for n in nums2:
            if len(stack) == 0 or stack[-1] > n:
                stack.append(n)
            else:
                while stack and stack[-1] < n:
                    last = stack.pop()
                    dict[last] = n
                stack.append(n)

        return [dict[i] if i in dict else -1 for i in nums1]

