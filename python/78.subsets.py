#
# @lc app=leetcode.cn id=78 lang=python3
#
# [78] 子集
#
# https://leetcode-cn.com/problems/subsets/description/
#
# algorithms
# Medium (72.41%)
# Total Accepted:    17.4K
# Total Submissions: 24.1K
# Testcase Example:  '[1,2,3]'
#
# 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
# 
# 说明：解集不能包含重复的子集。
# 
# 示例:
# 
# 输入: nums = [1,2,3]
# 输出:
# [
# ⁠ [3],
# [1],
# [2],
# [1,2,3],
# [1,3],
# [2,3],
# [1,2],
# []
# ]
# 
#
from typing import List


class Solution:
    # 不断递归调用
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        if len(nums) == 1:
            return [[], [nums[0]]]
        
        num = nums[0]
        sub_results = self.subsets(nums[1:])

        results = []
        for r in sub_results:
            raw = r
            added = r[:]
            added.append(num)

            results.append(raw)
            results.append(added)
        
        return results
        

