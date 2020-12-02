#
# @lc app=leetcode.cn id=540 lang=python3
#
# [540] 有序数组中的单一元素
#
# https://leetcode-cn.com/problems/single-element-in-a-sorted-array/description/
#
# algorithms
# Medium (61.57%)
# Total Accepted:    2.1K
# Total Submissions: 3.4K
# Testcase Example:  '[1,1,2]'
#
# 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
#
# 示例 1:
#
#
# 输入: [1,1,2,3,3,4,4,8,8]
# 输出: 2
#
#
# 示例 2:
#
#
# 输入: [3,3,7,7,10,11,11]
# 输出: 10
#
#
# 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
#
#
from typing import List


class Solution:
    # 关键信息在于有序数组
    # 可以使用二分法
    # 数组长度为奇数, 数组偶数位与其后的奇数位应相等如nums[0] == nums[1]
    def singleNonDuplicate(self, nums: List[int]) -> int:
        length = len(nums)
        if length == 0:
            return None
        elif length == 1:
            return nums[0]

        # 检查左右两边界
        if nums[0] != nums[1]:
            return nums[0]
        elif nums[-1] != nums[-2]:
            return nums[-1]

        # 二分法查找内部数据
        low = 0
        height = length - 1  # 长度一定为奇数
        mid = (height + low) // 2  # mid 永远为偶数位
        while True:
            if nums[mid - 1] < nums[mid] < nums[mid + 1]:
                return nums[mid]

            num1 = nums[mid]
            num2 = nums[mid + 1] if mid % 2 == 0 else nums[mid - 1]
            if num1 == num2:
                low = mid
            else:
                height = mid

            mid = (height + low) // 2


if __name__ == "__main__":
    Solution().singleNonDuplicate([3, 3, 7, 10, 10, 11, 11])
