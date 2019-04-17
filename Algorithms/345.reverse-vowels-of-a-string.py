#
# @lc app=leetcode.cn id=345 lang=python3
#
# [345] 反转字符串中的元音字母
#
# https://leetcode-cn.com/problems/reverse-vowels-of-a-string/description/
#
# algorithms
# Easy (46.05%)
# Total Accepted:    8.3K
# Total Submissions: 18K
# Testcase Example:  '"hello"'
#
# 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
#
# 示例 1:
#
# 输入: "hello"
# 输出: "holle"
#
#
# 示例 2:
#
# 输入: "leetcode"
# 输出: "leotcede"
#
# 说明:
# 元音字母不包含字母"y"。
#
#


class Solution:
    def reverseVowels(self, s: str) -> str:
        if s is None:
            return s

        length = len(s)
        if length == 0 or length == 1:
            return s

        # 包含大小写
        vowel = set(['a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U'])

        # 第一次遍历将字符串转为数组，并记录元音字母索引
        str_list = []
        vowel_list = []
        for i in range(length):
            ch = s[i]
            str_list.append(ch)

            if ch in vowel:
                vowel_list.append(i)

        # 交换记录的索引
        p, q = 0, len(vowel_list)-1
        while p < q:
            v_star = vowel_list[p]
            v_end = vowel_list[q]
            str_list[v_star], str_list[v_end] = str_list[v_end], str_list[v_star]

            p += 1
            q -= 1

        return "".join(str_list)
