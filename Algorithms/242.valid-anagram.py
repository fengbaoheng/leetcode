#
# @lc app=leetcode.cn id=242 lang=python3
#
# [242] 有效的字母异位词
#
# https://leetcode-cn.com/problems/valid-anagram/description/
#
# algorithms
# Easy (51.35%)
# Total Accepted:    25K
# Total Submissions: 48.6K
# Testcase Example:  '"anagram"\n"nagaram"'
#
# 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
#
# 示例 1:
#
# 输入: s = "anagram", t = "nagaram"
# 输出: true
#
#
# 示例 2:
#
# 输入: s = "rat", t = "car"
# 输出: false
#
# 说明:
# 你可以假设字符串只包含小写字母。
#
# 进阶:
# 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
#
#
class Solution:
    # 记录两个字符串 字母是否相同, 每个字母数量是否相同
    def isAnagram(self, s: str, t: str) -> bool:
        len_s = len(s)
        len_t = len(t)

        if len_s != len_t:
            return False
        if len_s == 0 and len_t == 0:
            return True

        d_s = {}
        for c in s:
            if c not in d_s:
                d_s[c] = 1
            else:
                d_s[c] += 1

        for c in t:
            if c not in d_s or d_s[c] == 0:
                return False
            else:
                d_s[c] -= 1


        return all(map(lambda x: x == 0, d_s.values()))
