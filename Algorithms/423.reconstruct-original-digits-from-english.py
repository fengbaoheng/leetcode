#
# @lc app=leetcode.cn id=423 lang=python3
#
# [423] 从英文中重建数字
#
class Solution:
    def originalDigits(self, s: str) -> str:
        count = {}

        letters = "zerontwhfuivsxg"
        for i in letters:
            count[i] = 0

        # 所有字母计数
        for i in s:
            count[i] += 1

        # 按数字特征计算
        count["zero"] = count["z"]
        count["two"] = count["w"]
        count["four"] = count["u"]
        count["six"] = count["x"]
        count["eight"] = count["g"]
        count["three"] = count["h"] - count["eight"]
        count["five"] = count["f"] - count["four"]
        count["seven"] = count["v"] - count["five"]
        count["one"] = count["o"] - count["zero"] - count["two"] - count["four"]
        count["nine"] = count["i"] - count["eight"] - count["six"] - count["five"]

        # 转换数字
        return (
            count["zero"] * "0"
            + count["one"] * "1"
            + count["two"] * "2"
            + count["three"] * "3"
            + count["four"] * "4"
            + count["five"] * "5"
            + count["six"] * "6"
            + count["seven"] * "7"
            + count["eight"] * "8"
            + count["nine"] * "9"
        )
