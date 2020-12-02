#
# @lc app=leetcode.cn id=541 lang=python3
#
# [541] 反转字符串 II
#
import unittest


class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        length = len(s)
        if s == 1 or k == 1:
            return s

        s = list(s)

        result = []
        double_k = k * 2
        i = 0
        remain = length - i

        # 剩余超过2k个字符
        while remain > double_k:
            # 前k个逆序
            front = s[i : i + k]
            front.reverse()

            # 后k个正序
            back = s[i + k : i + double_k]

            result.append(front)
            result.append(back)

            i += double_k
            remain = length - i

        # 剩余小于k个, 全部反转
        if remain < k:
            front = s[i:]
            front.reverse()
            result.append(front)
        # 剩余大于等于k 小于2k
        else:
            front = s[i : i + k]
            front.reverse()

            back = s[i + k :]

            result.append(front)
            result.append(back)

        return "".join(map(lambda x: "".join(x), result))


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_single(self):
        s, k = "a", 1
        self.assertEqual("a", self.solution.reverseStr(s, k))

        s, k = "a", 10000
        self.assertEqual("a", self.solution.reverseStr(s, k))

    def test_same_length(self):
        s, k, result = "abc", 3, "cba"
        self.assertEqual(result, self.solution.reverseStr(s, k))

        s, k, result = "abcdefg", 7, "gfedcba"
        self.assertEqual(result, self.solution.reverseStr(s, k))

    def test_min_k(self):
        s, k, result = "abc", 1, "abc"
        self.assertEqual(result, self.solution.reverseStr(s, k))

        s, k, result = "abc", 2, "bac"
        self.assertEqual(result, self.solution.reverseStr(s, k))

        s, k, result = "abcdefg", 1, "abcdefg"
        self.assertEqual(result, self.solution.reverseStr(s, k))

        s, k, result = "abcdefg", 2, "bacdfeg"
        self.assertEqual(result, self.solution.reverseStr(s, k))

    def test_remain(self):
        s, k, result = "abcdefg", 4, "dcbaefg"
        self.assertEqual(result, self.solution.reverseStr(s, k))

        s, k, result = "abcdefg", 3, "cbadefg"
        self.assertEqual(result, self.solution.reverseStr(s, k))

        s, k, result = "abcdefgh", 3, "cbadefhg"
        self.assertEqual(result, self.solution.reverseStr(s, k))


if __name__ == "__main__":
    unittest.main()

