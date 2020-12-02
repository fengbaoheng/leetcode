#
# @lc app=leetcode.cn id=189 lang=python3
#
# [189] 旋转数组
#
# https://leetcode-cn.com/problems/rotate-array/description/
#
# algorithms
# Easy (36.54%)
# Total Accepted:    39.1K
# Total Submissions: 106.4K
# Testcase Example:  '[1,2,3,4,5,6,7]\n3'
#
# 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
#
# 示例 1:
#
# 输入: [1,2,3,4,5,6,7] 和 k = 3
# 输出: [5,6,7,1,2,3,4]
# 解释:
# 向右旋转 1 步: [7,1,2,3,4,5,6]
# 向右旋转 2 步: [6,7,1,2,3,4,5]
# 向右旋转 3 步: [5,6,7,1,2,3,4]
#
#
# 示例 2:
#
# 输入: [-1,-100,3,99] 和 k = 2
# 输出: [3,99,-1,-100]
# 解释:
# 向右旋转 1 步: [99,-1,-100,3]
# 向右旋转 2 步: [3,99,-1,-100]
#
# 说明:
#
#
# 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
# 要求使用空间复杂度为 O(1) 的原地算法。
#
#
#


class Solution:
    # 1. 递归K次, 一次移动一步
    # 2. 计算每个元素的最终位置直接移动
    # 3. 三次翻转数组
    def rotate(self, nums: List[int], k: int) -> None:
        length = len(nums)
        k = k % length

        self.reverse(nums, 0, length)
        self.reverse(nums, 0, k)
        self.reverse(nums, k, length)

    def reverse(self, nums: List[int], start: int, end: int)->None:
        end-=1
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1
