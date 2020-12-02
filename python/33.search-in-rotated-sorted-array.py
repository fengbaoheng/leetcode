#
# @lc app=leetcode.cn id=33 lang=python3
#
# [33] 搜索旋转排序数组
#
# https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
#
# algorithms
# Medium (36.35%)
# Total Accepted:    21.4K
# Total Submissions: 58.8K
# Testcase Example:  '[4,5,6,7,0,1,2]\n0'
#
# 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
#
# ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
#
# 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
#
# 你可以假设数组中不存在重复的元素。
#
# 你的算法时间复杂度必须是 O(log n) 级别。
#
# 示例 1:
#
# 输入: nums = [4,5,6,7,0,1,2], target = 0
# 输出: 4
#
#
# 示例 2:
#
# 输入: nums = [4,5,6,7,0,1,2], target = 3
# 输出: -1
#
#
class Solution:
    # 思路
    # 排序数组被分为两部分,低区和高区
    # nums[0]为高区最小数, nums[-1]为低区最大数
    # 以这两个数为标尺进行二分查找
    def search(self, nums: List[int], target: int) -> int:
        if nums is None:
            return -1

        length = len(nums)
        if length == 0:
            return -1

        min_high, max_low = nums[0], nums[-1]

        dest = ""
        if max_low < target < min_high:
            return -1
        elif target <= max_low:
            dest = "low"
        else:
            dest = "high"

        p, q = 0, length - 1
        while p <= q:
            m = (p + q) // 2
            mid = nums[m]

            if target == mid:
                return m

            # low区
            if mid <= max_low:
                if dest == "high":
                    q = m - 1
                else:
                    if target < mid:
                        q = m - 1
                    else:
                        p = m + 1
            # high区
            elif mid >= min_high:
                if dest == "low":
                    p = m + 1
                else:
                    if target < mid:
                        q = m - 1
                    else:
                        p = m + 1

        return -1

