#
# @lc app=leetcode.cn id=81 lang=python3
#
# [81] 搜索旋转排序数组 II
#
# https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/description/
#
# algorithms
# Medium (32.85%)
# Total Accepted:    5.2K
# Total Submissions: 15.7K
# Testcase Example:  '[2,5,6,0,0,1,2]\n0'
#
# 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
#
# ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
#
# 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
#
# 示例 1:
#
# 输入: nums = [2,5,6,0,0,1,2], target = 0
# 输出: true
#
#
# 示例 2:
#
# 输入: nums = [2,5,6,0,0,1,2], target = 3
# 输出: false
#
# 进阶:
#
#
# 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
# 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
#
#
#
class Solution:
    # 思路
    # 排序数组被分为两部分,低区和高区
    # nums[0]为高区最小数, nums[-1]为低区最大数
    # 以这两个数为标尺进行二分查找
    def search(self, nums: List[int], target: int) -> bool:
        if nums is None:
            return False

        length = len(nums)
        if length == 0:
            return False

        p, q = 0, length - 1
        min_high, max_low = nums[0], nums[-1]

        # 有重复元素则首尾元素不能够一样
        if min_high == max_low:
            for i in range(length):
                if nums[i] != min_high:
                    min_high = nums[i]
                    p = i
                    break
            # 所有元素都相等
            if min_high == max_low:
                return min_high == target

        dest = ""
        if max_low < target < min_high:
            return False
        elif target <= max_low:
            dest = "low"
        else:
            dest = "high"

        while p <= q:
            m = (p + q) // 2
            mid = nums[m]

            if target == mid:
                return True

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

        return False
