#
# @lc app=leetcode.cn id=528 lang=python3
#
# [528] Random Pick with Weight
#
# https://leetcode-cn.com/problems/random-pick-with-weight/description/
#
# algorithms
# Medium (36.82%)
# Total Accepted:    294
# Total Submissions: 796
# Testcase Example:  '["Solution", "pickIndex"]\n[[[1]], []]'
#
# 给定一个正整数数组 w ，其中 w[i] 代表位置 i 的权重，请写一个函数 pickIndex ，它可以随机地获取位置 i，选取位置 i 的概率与
# w[i] 成正比。
#
# 说明:
#
#
# 1 <= w.length <= 10000
# 1 <= w[i] <= 10^5
# pickIndex 将被调用不超过 10000 次
#
#
# 示例1:
#
#
# 输入:
# ["Solution","pickIndex"]
# [[[1]],[]]
# 输出: [null,0]
#
#
# 示例2:
#
#
# 输入:
# ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
# [[[1,3]],[],[],[],[],[]]
# 输出: [null,0,1,1,1,0]
#
# 输入语法说明：
#
# 输入是两个列表：调用成员函数名和调用的参数。Solution 的构造函数有一个参数，即数组 w。pickIndex
# 没有参数。输入参数是一个列表，即使参数为空，也会输入一个 [] 空列表。
#
#
import random


class Solution:
    # 轮盘赌算法
    def __init__(self, w: List[int]):
        # 选中概率
        sum_w = sum(w)
        self.p = [w[i] / sum_w for i in range(len(w))]

        # 累积概率
        self.ap = self.p[:]
        for i in range(1, len(w)):
            self.ap[i] += self.ap[i - 1]

    def pickIndex(self) -> int:
        r = random.uniform(0, 1)

        # 二分查找
        p = 0
        q = len(self.ap) - 1
        while p <= q:
            m = (p + q) // 2
            if self.ap[m] < r <= self.ap[m+1]:
                return m + 1
            elif self.ap[m] < r:
                p = m + 1
            else:
                q = m - 1

        return m
