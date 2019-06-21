#
# @lc app=leetcode.cn id=482 lang=python3
#
# [482] 密钥格式化
#
import unittest


class Solution:
    def licenseKeyFormatting(self, S: str, K: int) -> str:
        length = len(S)
        if length == 0:
            return ""

        if K <= 0:
            raise Exception("不合法K")

        s_list = []
        upper_base = -ord("a") + ord("A")
        for s in S:
            if s == "-":
                continue
            elif "a" <= s <= "z":
                s_list.append(chr(ord(s) + upper_base))
            else:
                s_list.append(s)

        s_arr = []
        index = len(s_list)

        while index > K:
            index -= K
            s_arr.append("".join(s_list[index : index + K]))

        s_arr.append("".join(s_list[:index]))

        s_arr.reverse()

        return "-".join(s_arr)


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_empty(self):
        S = ""
        result = self.solution.licenseKeyFormatting(S, 0)
        self.assertEqual("", result)

        result = self.solution.licenseKeyFormatting(S, 1)
        self.assertEqual("", result)

        result = self.solution.licenseKeyFormatting(S, 99)
        self.assertEqual("", result)

    def test_big_k(self):
        S = "abcd"
        result = self.solution.licenseKeyFormatting(S, 4)
        self.assertEqual("ABCD", result)

        result = self.solution.licenseKeyFormatting(S, 3)
        self.assertEqual("A-BCD", result)

        result = self.solution.licenseKeyFormatting(S, 99)
        self.assertEqual("ABCD", result)

    def test_default(self):
        S = "5F3Z-2e-9-w"
        result = self.solution.licenseKeyFormatting(S, 4)
        self.assertEqual("5F3Z-2E9W", result)

        S = "2-5g-3-J"
        result = self.solution.licenseKeyFormatting(S, 2)
        self.assertEqual("2-5G-3J", result)


if __name__ == "__main__":
    unittest.main()

