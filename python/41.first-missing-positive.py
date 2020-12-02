#
# @lc app=leetcode.cn id=41 lang=python3
#
# [41] 缺失的第一个正数
#
# https://leetcode-cn.com/problems/first-missing-positive/description/
#
# algorithms
# Hard (35.29%)
# Total Accepted:    12K
# Total Submissions: 34.1K
# Testcase Example:  '[1,2,0]'
#
# 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
#
# 示例 1:
#
# 输入: [1,2,0]
# 输出: 3
#
#
# 示例 2:
#
# 输入: [3,4,-1,1]
# 输出: 2
#
#
# 示例 3:
#
# 输入: [7,8,9,11,12]
# 输出: 1
#
#
# 说明:
#
# 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
#
#
from typing import List


class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        if nums is None:
            return 1

        length = len(nums)
        if length == 0:
            return 1

        for i in range(length):
            if nums[i] <= 0 or nums[i] > length:
                nums[i] = 0

        for i in range(length):
            cur_num = abs(nums[i])
            if cur_num != 0:
                index = cur_num - 1
                target_num = abs(nums[index])
                if target_num == 0:
                    nums[index] = - cur_num
                else:
                    nums[index] = -target_num

        for i in range(length):
            if nums[i] >= 0:
                return i + 1

        return length + 1


if __name__ == "__main__":
    print(Solution().firstMissingPositive([0, 1, 2]))
