#
# @lc app=leetcode.cn id=389 lang=python3
#
# [389] 找不同
#
# https://leetcode-cn.com/problems/find-the-difference/description/
#
# algorithms
# Easy (54.49%)
# Total Accepted:    7K
# Total Submissions: 12.7K
# Testcase Example:  '"abcd"\n"abcde"'
#
# 给定两个字符串 s 和 t，它们只包含小写字母。
#
# 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
#
# 请找出在 t 中被添加的字母。
#
#
#
# 示例:
#
# 输入：
# s = "abcd"
# t = "abcde"
#
# 输出：
# e
#
# 解释：
# 'e' 是那个被添加的字母。
#
#
#
class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        d = {}
        for ch in s:
            if ch not in d:
                d[ch] = 0
            d[ch] += 1

        for ch in t:
            if ch not in d or d[ch] == 0:
                return ch
            else:
                d[ch] -= 1

