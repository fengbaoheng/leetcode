#
# @lc app=leetcode.cn id=1051 lang=python3
#
# [1051] 高度检查器
#
from typing import List

class Solution:
    # 将排序后的数组与原数组比对,计算不同者的个数
    def heightChecker(self, heights: List[int]) -> int:
        sorted_heights= sorted(heights)
        
        count = 0
        for i in range(len(heights)):
            if(sorted_heights[i] != heights[i]):
                count += 1

        return count

        

