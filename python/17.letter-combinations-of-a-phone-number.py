#
# @lc app=leetcode.cn id=17 lang=python3
#
# [17] 电话号码的字母组合
#
# https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
#
# algorithms
# Medium (48.03%)
# Total Accepted:    18.7K
# Total Submissions: 38.9K
# Testcase Example:  '"23"'
#
# 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
#
# 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
#
#
#
# 示例:
#
# 输入："23"
# 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
#
#
# 说明:
# 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
#
#
from typing import List


class Solution:
    # 递归
    def letterCombinations(self, digits: str) -> List[str]:
        length = len(digits)
        if length == 0:
            return []

        alphabet = {
            "1": ["*"],
            "2": ["a", "b", "c"],
            "3": ["d", "e", "f"],
            "4": ["g", "h", "i"],
            "5": ["j", "k", "l"],
            "6": ["m", "n", "o"],
            "7": ["p", "q", "r", "s"],
            "8": ["t", "u", "v"],
            "9": ["w", "x", "y", "z"],
        }

        # 初始取第一位数字，在其上叠加
        results = alphabet[digits[0]]

        # 迭代每位数字
        for i in range(1, length):
            added_results = []
            num = digits[i]
            # 在之前的结果上加上新数字对应的多个字符
            for result in results:
                for letter in alphabet[num]:
                    added_results.append(result+letter)
            results = added_results

        return results

