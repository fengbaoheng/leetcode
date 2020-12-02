#
# @lc app=leetcode.cn id=824 lang=python3
#
# [824] 山羊拉丁文
#


class Solution:
    def toGoatLatin(self, S: str) -> str:
        try:
            raw_words = S.split(" ")
            goat_words = []

            aeiou = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}

            for i in range(len(raw_words)):
                word = raw_words[i]

                if word[0] not in aeiou:
                    word = word[1:] + word[0]

                goat_words.append(word + "ma" + (i+1)*'a')

            return " ".join(goat_words)
        except:
            return ""
