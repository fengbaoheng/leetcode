#
# @lc app=leetcode.cn id=205 lang=python3
#
# [205] 同构字符串
#
# https://leetcode-cn.com/problems/isomorphic-strings/description/
#
# algorithms
# Easy (42.97%)
# Total Accepted:    7.9K
# Total Submissions: 18.4K
# Testcase Example:  '"egg"\n"add"'
#
# 给定两个字符串 s 和 t，判断它们是否是同构的。
#
# 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
#
# 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
#
# 示例 1:
#
# 输入: s = "egg", t = "add"
# 输出: true
#
#
# 示例 2:
#
# 输入: s = "foo", t = "bar"
# 输出: false
#
# 示例 3:
#
# 输入: s = "paper", t = "title"
# 输出: true
#
# 说明:
# 你可以假设 s 和 t 具有相同的长度。
#
#
class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        len_s = len(s)
        len_t = len(t)

        if len_s != len_t:
            return False
        elif len_s <= 1 and len_t <= 1:
            return True

        # 记录映射
        ds = {}
        dt = {}

        for i in range(len_s):
            si = s[i]
            ti = t[i]

            # 二者都不在映射中
            if si not in ds:
                if ti not in dt:
                    ds[si] = ti
                    dt[ti] = si
                else:
                    return False
            # 二者同在映射中，且映射对应的字符相等
            else:
                if ti not in dt:
                    return False
                else:
                    dti = ds[si]
                    dsi = dt[ti]

                    if dti != ti or dsi != si:
                        return False

        return True

