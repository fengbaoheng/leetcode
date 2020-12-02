#
# @lc app=leetcode.cn id=344 lang=python3
#
# [344] 反转字符串
#
# https://leetcode-cn.com/problems/reverse-string/description/
#
# algorithms
# Easy (65.69%)
# Total Accepted:    45.5K
# Total Submissions: 69.3K
# Testcase Example:  '["h","e","l","l","o"]'
#
# 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
#
# 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
#
# 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
#
#
#
# 示例 1：
#
# 输入：["h","e","l","l","o"]
# 输出：["o","l","l","e","h"]
#
#
# 示例 2：
#
# 输入：["H","a","n","n","a","h"]
# 输出：["h","a","n","n","a","H"]
#
#
from typing import List


class Solution:
    def reverseString(self, s: List[str]) -> None:
        if s is None:
            return

        length = len(s)
        if length == 0 or length == 1:
            return

        # 原地修改，首尾双指针翻转
        p = 0
        q = length - 1
        while p <= q:
            s[p], s[q] = s[q], s[p]
            p += 1
            q -= 1
