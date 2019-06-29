#
# @lc app=leetcode.cn id=905 lang=python3
#
# [905] 按奇偶排序数组
#

from typing import List


class Solution:
    # 头尾双指针
    def sortArrayByParity(self, A: List[int]) -> List[int]:
        length = len(A)

        if length <= 1:
            return A

        p, q = 0, length - 1
        while p < q:
            # 头指针遇奇数
            while p < q and A[p] % 2 == 0:
                p += 1

            # 尾指针遇偶数
            while p < q and A[q] % 2 != 0:
                q -= 1

            A[p], A[q] = A[q], A[p]

        return A


if __name__ == "__main__":

    Solution().sortArrayByParity([1, 2, 6, 11, 9, 4, 3, 6, 3, 2, 0, 1, 3, 6, 0])