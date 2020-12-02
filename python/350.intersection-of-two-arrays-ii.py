#
# @lc app=leetcode.cn id=350 lang=python3
#
# [350] 两个数组的交集 II
#
# https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/description/
#
# algorithms
# Easy (40.57%)
# Total Accepted:    30.3K
# Total Submissions: 74.6K
# Testcase Example:  '[1,2,2,1]\n[2,2]'
#
# 给定两个数组，编写一个函数来计算它们的交集。
#
# 示例 1:
#
# 输入: nums1 = [1,2,2,1], nums2 = [2,2]
# 输出: [2,2]
#
#
# 示例 2:
#
# 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
# 输出: [4,9]
#
# 说明：
#
#
# 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
# 我们可以不考虑输出结果的顺序。
#
#
# 进阶:
#
#
# 如果给定的数组已经排好序呢？你将如何优化你的算法？
# 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
# 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
#
#
#
from typing import List


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1) == 0 or len(nums2) == 0:
            return []

        # 分辨出长数组和短数组
        short_nums, long_nums = (nums1, nums2) if len(
            nums1) < len(nums2) else (nums2, nums1)

        # 先遍历较短的数组，记录每个数字和出现的次数保存字典
        num_dict = {}
        for num in short_nums:
            if num in num_dict:
                num_dict[num] += 1
            else:
                num_dict[num] = 1

        # 再遍历较长的数组（可以提前终止），记录在字典出现的数字，并将次数-1，直至0
        result = []
        for num in long_nums:
            if num in num_dict:
                result.append(num)
                if num_dict[num] <= 1:
                    num_dict.pop(num)
                    # 字典中全部匹配完，就提前终止了
                    if len(num_dict) == 0:
                        break
                else:
                    num_dict[num] -= 1
                

        return result
