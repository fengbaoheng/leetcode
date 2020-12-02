#
# @lc app=leetcode.cn id=342 lang=python3
#
# [342] 4的幂
#


class Solution:
    # 分析二进制的规律
    #  1: 0000 0001
    #  4: 0000 0100
    # 16: 0001 0000
    # 64: 0100 0000
    def isPowerOfFour(self, num: int) -> bool:
        if num < 0:
            return False

        str = bin(num)[::-1]

        index = -1
        for i in range(len(str)):
            if str[i] == "1":
                # 1的位置在偶数 且只有一个1
                if i % 2 != 0 or index != -1:
                    return False
                else:
                    index = i

        return index % 2 == 0
