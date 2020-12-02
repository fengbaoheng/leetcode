#
# @lc app=leetcode.cn id=287 lang=python3
#
# [287] 寻找重复数
#
# https://leetcode-cn.com/problems/find-the-duplicate-number/description/
#
# algorithms
# Medium (58.60%)
# Total Accepted:    9K
# Total Submissions: 15.4K
# Testcase Example:  '[1,3,4,2,2]'
#
# 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和
# n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
#
# 示例 1:
#
# 输入: [1,3,4,2,2]
# 输出: 2
#
#
# 示例 2:
#
# 输入: [3,1,3,4,2]
# 输出: 3
#
#
# 说明：
#
#
# 不能更改原数组（假设数组是只读的）。
# 只能使用额外的 O(1) 的空间。
# 时间复杂度小于 O(n^2) 。
# 数组中只有一个重复的数字，但它可能不止重复出现一次。
#
#
#
from typing import List


class Solution:
    # 题目只有一个重复数
    # 扫描时, 把当前位置i的数nums[i]置换到该数目标位置j = nums[i]-1去
    # 若目标位置数字nums[j]与当前数nums[i]一致,则重复,返回该数
    # 否则则交换两数进行下一轮判断
    def findDuplicate(self, nums: List[int]) -> int:
        length = len(nums)

        i = 0
        while i < length:
            cur_num = nums[i]
            j = cur_num - 1

            # 数字在正确的位置上
            if i == j:
                i += 1
                continue

            target_num = nums[j]
            if cur_num == target_num:
                return target_num
            else:
                nums[i], nums[j] = nums[j], nums[i]

