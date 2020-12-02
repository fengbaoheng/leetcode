#
# @lc app=leetcode.cn id=908 lang=python3
#
# [908] 最小差值 I
#
from typing import List


class Solution:
    # 核心依然是找到最大值和最小值进行比较
    # 最大值减少K 和最小值增加K
    # 若二者的边界都能相交, 则其他所有数必然相交,即输出0
    # 否则这二者的差值即为结果
    def smallestRangeI(self, A: List[int], K: int) -> int:
        if len(A) == 0:
            return 0

        inf = float("inf")
        maxNum = -inf
        minNum = inf

        for num in A:
            if num < minNum:
                minNum = num
            if num > maxNum:
                maxNum = num

        minNum += K
        maxNum -= K

        if minNum >= maxNum:
            return 0
        else:
            return maxNum - minNum


if __name__ == "__main__":
    Solution().smallestRangeI([0, 10], 2)

