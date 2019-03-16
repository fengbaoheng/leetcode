#
# @lc app=leetcode.cn id=303 lang=python3
#
# [303] 区域和检索 - 数组不可变
#
# https://leetcode-cn.com/problems/range-sum-query-immutable/description/
#
# algorithms
# Easy (51.50%)
# Total Accepted:    8.1K
# Total Submissions: 15.6K
# Testcase Example:  '["NumArray","sumRange","sumRange","sumRange"]\n[[[-2,0,3,-5,2,-1]],[0,2],[2,5],[0,5]]'
#
# 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
#
# 示例：
#
# 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
#
# sumRange(0, 2) -> 1
# sumRange(2, 5) -> -1
# sumRange(0, 5) -> -3
#
# 说明:
#
#
# 你可以假设数组不可变。
# 会多次调用 sumRange 方法。
#
#
#
class NumArray:

    # 重点在于多次调用
    # 因此可以记录每个位置的累积和
    def __init__(self, nums: List[int]):
        if len(nums) == 0:
            return

        add = []
        add.append(nums[0])
        for i in range(1, len(nums)):
            add.append(nums[i] + add[-1])

        self.add = add
        self.nums = nums

    def sumRange(self, i: int, j: int) -> int:
        if i == 0:
            return self.add[j]
        else:
            return self.add[j] - self.add[i - 1]


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(i,j)

