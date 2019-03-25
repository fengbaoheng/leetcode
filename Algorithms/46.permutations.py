#
# @lc app=leetcode.cn id=46 lang=python3
#
# [46] 全排列
#
# https://leetcode-cn.com/problems/permutations/description/
#
# algorithms
# Medium (67.06%)
# Total Accepted:    18.2K
# Total Submissions: 27.1K
# Testcase Example:  '[1,2,3]'
#
# 给定一个没有重复数字的序列，返回其所有可能的全排列。
# 
# 示例:
# 
# 输入: [1,2,3]
# 输出:
# [
# ⁠ [1,2,3],
# ⁠ [1,3,2],
# ⁠ [2,1,3],
# ⁠ [2,3,1],
# ⁠ [3,1,2],
# ⁠ [3,2,1]
# ]
# 
#
from typing import *

class Solution:
    # 分治 求出子数组的全排列和自身组合
    def permute(self, nums: List[int]) -> List[List[int]]:
        length = len(nums)
        if length == 0:
            return [[]]
        elif length == 1:
            return [nums]
        elif length == 2:
            return [nums, nums[::-1]]
        
        # 取出第一个数
        num = nums[0]

        # 求出剩余数组的全排列
        sub_results = self.permute(nums[1:])

        # 组合
        results = []
        for sub_result in sub_results:
            for i in range(length):
                result = sub_result[:]
                result.insert(i, num)
                results.append(result)
        
        return results

if __name__ == "__main__":
    a = Solution().permute([1])
    print(a)
            



        

