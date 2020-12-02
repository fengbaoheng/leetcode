#
# @lc app=leetcode.cn id=190 lang=python
#
# [190] 颠倒二进制位
#
class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        m = 0
        for i in range(32):
            m = (m << 1) | (n & 1)
            n = n>>1
        return m
        

