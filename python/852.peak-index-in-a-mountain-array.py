#
# @lc app=leetcode.cn id=852 lang=python3
#
# [852] 山脉数组的峰顶索引
#

from typing import List


class Solution:
    # 在确保有山峰的输入下,即寻找数组max值的索引
    # 无序数组可遍历查找, 本题可使用二分法查找
    def peakIndexInMountainArray(self, A: List[int]) -> int:
        try:
            length = len(A)

            # 题目保证数组长度>3
            # p,q取值避免了判断数组两端边界
            p, q = 1, length - 2

            while p < q:
                m = p // 2 + q // 2

                left = A[m - 1]
                mid = A[m]
                right = A[m + 1]

                if left < mid:  # 在上坡或峰顶
                    if mid > right: # 在峰顶
                        return m
                    else: # 上坡
                        p = m + 1
                else:  # 在下坡
                    q = m - 1

            return p

        except Exception as e:
            raise e

