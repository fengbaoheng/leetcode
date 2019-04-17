#
# @lc app=leetcode.cn id=520 lang=python3
#
# [520] 检测大写字母
#
# https://leetcode-cn.com/problems/detect-capital/description/
#
# algorithms
# Easy (51.84%)
# Total Accepted:    6.7K
# Total Submissions: 12.9K
# Testcase Example:  '"USA"'
#
# 给定一个单词，你需要判断单词的大写使用是否正确。
#
# 我们定义，在以下情况时，单词的大写用法是正确的：
#
#
# 全部字母都是大写，比如"USA"。
# 单词中所有字母都不是大写，比如"leetcode"。
# 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
#
#
# 否则，我们定义这个单词没有正确使用大写字母。
#
# 示例 1:
#
#
# 输入: "USA"
# 输出: True
#
#
# 示例 2:
#
#
# 输入: "FlaG"
# 输出: False
#
#
# 注意: 输入是由大写和小写拉丁字母组成的非空单词。
#
#


class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        length = len(word)
        if length == 1:
            return True

        # 长度都大于1
        if word[0].isupper():
            # 全大写
            if word[1].isupper():
                for i in range(2, length):
                    if word[i].islower():
                        return False
            else:
                # 仅首字母大写
                for i in range(2, length):
                    if word[i].isupper():
                        return False
        else:
            # 全小写
            for i in range(1, length):
                if word[i].isupper():
                    return False

        return True
