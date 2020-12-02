#
# @lc app=leetcode.cn id=977 lang=python3
#
# [977] 有序数组的平方
#
from typing import List


class Solution:
    # 头尾指针逐步内缩
    # 从大到小排序
    def sortedSquares(self, A: List[int]) -> List[int]:
        try:
            length = len(A)
            if length == 0:
                return A

            p, q = 0, length - 1
            result = []
            while len(result) != length:
                # 剩下的全为正数或全为负数
                # 即p-q间的平方数大小顺序已定
                if A[p] >= 0:
                    for i in range(q, p-1, -1):
                        result.append(A[i]*A[i])
                elif A[q] < 0:
                    for i in range(p, q+1, 1):
                        result.append(A[i]*A[i])
                else:
                    if abs(A[p]) < abs(A[q]):
                        result.append(A[q]*A[q])
                        q -= 1
                    else:
                        result.append(A[p]*A[p])
                        p += 1

            result.reverse()
            return result

        except Exception as e:
            raise e
