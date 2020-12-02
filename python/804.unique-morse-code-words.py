#
# @lc app=leetcode.cn id=804 lang=python3
#
# [804] 唯一摩尔斯密码词
#
from typing import List


class Solution:
    # 依次将单词转化后存入set集合去重即可
    # 如果包含大小写还需转换
    # 不考虑空格
    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        try:
            table = [
                ".-",
                "-...",
                "-.-.",
                "-..",
                ".",
                "..-.",
                "--.",
                "....",
                "..",
                ".---",
                "-.-",
                ".-..",
                "--",
                "-.",
                "---",
                ".--.",
                "--.-",
                ".-.",
                "...",
                "-",
                "..-",
                "...-",
                ".--",
                "-..-",
                "-.--",
                "--..",
            ]

            morse_set = set([])
            for word in words:
                morse_set.add("".join(map(lambda ch: table[ord(ch)-97], list(word))))

            return len(morse_set)

        except Exception as e:
            raise e


if __name__ == "__main__":
    Solution().uniqueMorseRepresentations(["gin"])

