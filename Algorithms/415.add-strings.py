#
# @lc app=leetcode.cn id=415 lang=python3
#
# [415] 字符串相加
#
class Solution:
    # 字符串拆分为链表或数组,逐位相加
    # 直接转成数字会超出最大整数范围
    def addStrings(self, num1: str, num2: str) -> str:
        short_num, long_num = (num1, num2) if len(num1) < len(num2) else (num2, num1)

        short_length = len(short_num)
        long_length = len(long_num)

        if short_length == 0:
            return long_num
        elif long_length == 0:
            return short_num

        # 转换为数组形式,并倒序
        short_num = list(short_num)
        short_num.reverse()

        long_num = list(long_num)
        long_num.reverse()

        carry = 0
        num = []

        # 逐位相加
        for i in range(short_length):
            s = int(short_num[i]) + int(long_num[i]) + carry
            if s >= 10:
                carry = 1
                s -= 10
            else:
                carry = 0

            num.append(s)

        # 处理长数组剩余的数字
        for i in range(short_length, long_length):
            s = int(long_num[i]) + carry
            if s >= 10:
                carry = 1
                num.append(s - 10)
            else:
                carry = 0
                num.append(s)
                num.extend(long_num[i + 1 :])
                break

        # 最高位需要进1
        if carry == 1:
            num.append(1)

        num.reverse()
        return "".join(map(str, num))


if __name__ == "__main__":
    print(Solution().addStrings("1234", "9999"))

