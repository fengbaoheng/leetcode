#
# @lc app=leetcode.cn id=1122 lang=python3
#
# [1122] 数组的相对排序
#
from typing import List
from collections import OrderedDict

class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        dict = OrderedDict()

        for num in arr2:
            dict[num] = 0
        
        back = []

        for num in arr1:
            if num in dict:
                dict[num] += 1
            else:
                back.append(num)

        front = []
        for key,value in dict.items():
            for i in range(value):
                front.append(key)
        
        back.sort()

        return front + back
