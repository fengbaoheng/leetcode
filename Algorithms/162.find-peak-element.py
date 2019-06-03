#
# @lc app=leetcode.cn id=162 lang=python3
#
# [162] 寻找峰值
#
from typing import List


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        try:
            if not nums:
                raise Exception()

            length = len(nums)

            # 仅有一个数一定是山峰
            if length == 1:
                return 0

            # 判断两个边界是否是山峰
            if nums[0] > nums[1]:
                return 0

            if nums[-1] > nums[-2]:
                return length - 1

            # 二分法查找中间数组
            p, q = 1, length - 2
            while p < q:
                m = p + (q - p) // 2

                # 判断中点是否为山峰
                if nums[m - 1] < nums[m] > nums[m + 1]:
                    return m
                # 上坡
                elif nums[m - 1] < nums[m]:
                    p = m + 1
                # 下坡
                else:
                    q = m - 1

            return p

        except Exception as e:
            raise e


if __name__ == "__main__":
    print(Solution().findPeakElement([3,5,6,10]))