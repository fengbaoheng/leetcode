#
# @lc app=leetcode.cn id=537 lang=python3
#
# [537] 复数乘法
#
from typing import Tuple


class Solution:
    # 将字符串转为数字格式,得到a1, b1, a2, b2四个系数
    # 根据乘法公式,结果为 a1a2 + (a1b2 + b1a2)i - b1b2
    # 最后组合字符串输出
    def complexNumberMultiply(self, a: str, b: str) -> str:
        # 字符串转数字
        a1, b1 = self.split_num(a)
        a2, b2 = self.split_num(b)

        # 计算结果
        a3 = a1 * a2 - b1 * b2
        b3 = a1 * b2 + b1 * a2

        return self.combine_num(a3, b3)

    # 将字符串拆分复数,返回(a,b)
    def split_num(self, s: str) -> Tuple[int]:
        str_a, str_bi = s.split('+')
        a = int(str_a)
        b = int(str_bi[:-1])
        return (a, b)

    # 组合成复数的字符串
    def combine_num(self, a: int, b: int) -> str:
        return "{}+{}i".format(a, b)

