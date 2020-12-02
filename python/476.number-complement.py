#
# @lc app=leetcode.cn id=476 lang=python3
#
# [476] 数字的补数
#
class Solution:
    # 与1异或， 0^1=1 1^1=0
    def findComplement(self, num: int) -> int:
        # 计算二进制格式有bin_count位
        bin_count = len(bin(num)) - 2

        # bin_count位全为1的二进制数
        bin_1 = pow(2, bin_count) - 1

        # 异或
        return bin_1 ^ num


if __name__ == "__main__":
    print(Solution().findComplement(5))

