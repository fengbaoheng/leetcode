#
# @lc app=leetcode.cn id=34 lang=python3
#
# [34] 在排序数组中查找元素的第一个和最后一个位置
#
# https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
#
# algorithms
# Medium (35.19%)
# Total Accepted:    12.9K
# Total Submissions: 36.6K
# Testcase Example:  '[5,7,7,8,8,10]\n8'
#
# 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
#
# 你的算法时间复杂度必须是 O(log n) 级别。
#
# 如果数组中不存在目标值，返回 [-1, -1]。
#
# 示例 1:
#
# 输入: nums = [5,7,7,8,8,10], target = 8
# 输出: [3,4]
#
# 示例 2:
#
# 输入: nums = [5,7,7,8,8,10], target = 6
# 输出: [-1,-1]
#
#
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        length = len(nums)
        if length == 0:
            return [-1, -1]
        elif length == 1:
            return [0, 0] if nums[0] == target else [-1, -1]

        left = 0
        right = length - 1
        while left < right:
            mid = int((left + right) / 2)
            num = nums[mid]
            if num == target:
                i = j = mid
                while i >= 0 and nums[i] == target:
                    i -= 1
                while j < length and nums[j] == target:
                    j += 1
                return [i+1, j-1]
            elif num < target:
                left = mid + 1
            elif num > target:
                right = mid - 1

        return [-1, -1]



