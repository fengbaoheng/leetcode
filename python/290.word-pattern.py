#
# @lc app=leetcode.cn id=290 lang=python3
#
# [290] 单词模式
#
# https://leetcode-cn.com/problems/word-pattern/description/
#
# algorithms
# Easy (36.58%)
# Total Accepted:    5.2K
# Total Submissions: 13.8K
# Testcase Example:  '"abba"\n"dog cat cat dog"'
#
# 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
#
# 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
#
# 示例1:
#
# 输入: pattern = "abba", str = "dog cat cat dog"
# 输出: true
#
# 示例 2:
#
# 输入:pattern = "abba", str = "dog cat cat fish"
# 输出: false
#
# 示例 3:
#
# 输入: pattern = "aaaa", str = "dog cat cat dog"
# 输出: false
#
# 示例 4:
#
# 输入: pattern = "abba", str = "dog dog dog dog"
# 输出: false
#
# 说明:
# 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
#
#


class Solution:
    def wordPattern(self, pattern: str, str: str) -> bool:

        str_list = str.split(' ')
        if len(str_list) != len(pattern):
            return False

        p_dict = {}

        for i in range(len(str_list)):
            s = str_list[i]
            p = pattern[i]

            if p not in p_dict:
                # 不同pattern对应的value也必须不同
                # a对应dog 则b不能为dog
                if s in p_dict.values():
                    return False
                else:
                    p_dict[p] = s
            else:
                if p_dict[p] != s:
                    return False
        return True
