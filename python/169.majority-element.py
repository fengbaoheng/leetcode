#
# @lc app=leetcode.cn id=169 lang=python3
#
# [169] 求众数
#
# https://leetcode-cn.com/problems/majority-element/description/
#
# algorithms
# Easy (57.97%)
# Total Accepted:    27.1K
# Total Submissions: 46.5K
# Testcase Example:  '[3,2,3]'
#
# 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
# 
# 你可以假设数组是非空的，并且给定的数组总是存在众数。
# 
# 示例 1:
# 
# 输入: [3,2,3]
# 输出: 3
# 
# 示例 2:
# 
# 输入: [2,2,1,1,1,2,2]
# 输出: 2
# 
# 
#
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        n = len(nums)/2
        count_dict = {}
        
        for num in nums:
            if num not in count_dict:
                count_dict[num] = 0
            
            count_dict[num] += 1
            if(count_dict[num] > n):
                return num
        

