#
# @lc app=leetcode.cn id=125 lang=python3
#
# [125] 验证回文串
#
# https://leetcode-cn.com/problems/valid-palindrome/description/
#
# algorithms
# Easy (38.29%)
# Total Accepted:    27K
# Total Submissions: 70.2K
# Testcase Example:  '"A man, a plan, a canal: Panama"'
#
# 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
#
# 说明：本题中，我们将空字符串定义为有效的回文串。
#
# 示例 1:
#
# 输入: "A man, a plan, a canal: Panama"
# 输出: true
#
#
# 示例 2:
#
# 输入: "race a car"
# 输出: false
#
#
#
class Solution:
    def isPalindrome(self, s: str) -> bool:
        # 第一遍过滤，只保留字母和数字，同时把字母变为小写
        char_list = []
        for c in s:
            if (c >= "0" and c <= "9") or (c >= "a" and c <= "z"):
                char_list.append(c)
            elif c >= "A" and c <= "Z":
                char_list.append(chr(ord(c) + 32))

        # 第二遍判断是否回文
        length = len(char_list)
        if length <= 1:
            return True

        i = 0
        j = length - 1

        while i < j:
            if char_list[i] != char_list[j]:
                return False
            i += 1
            j -= 1
        return True


if __name__ == "__main__":
    Solution().isPalindrome("0P")

