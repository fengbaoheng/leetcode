#
# @lc app=leetcode.cn id=670 lang=python3
#
# [670] 最大交换
#
# https://leetcode-cn.com/problems/maximum-swap/description/
#
# algorithms
# Medium (34.36%)
# Total Accepted:    1.2K
# Total Submissions: 3.5K
# Testcase Example:  '2736'
#
# 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
#
# 示例 1 :
#
#
# 输入: 2736
# 输出: 7236
# 解释: 交换数字2和数字7。
#
#
# 示例 2 :
#
#
# 输入: 9973
# 输出: 9973
# 解释: 不需要交换。
#
#
# 注意:
#
#
# 给定数字的范围是 [0, 10^8]
#
#
#
from typing import List


class Solution:
    def maximumSwap(self, num: int) -> int:
        if num == 0:
            return num

        # 转换为数字数组
        num_list = list(map(int, list(str(num))))

        swaped_num_list = self.swap(num_list)

        return int("".join(map(str, swaped_num_list)))

    def swap(self, num_list: List[int])->List[int]:
        if len(num_list) == 1:
            return num_list

        max_num = max(num_list)
        # 首位非最大的数,则把list中最后一个最大的数交换到首尾
        if num_list[0] != max_num:
            index = self.find_last_index(num_list, max_num)
            num_list[0], num_list[index] = num_list[index], num_list[0]
            return num_list
        # 迭代
        else:
            return num_list[0:1] + self.swap(num_list[1:])

    # 寻找指定数字在列表中的最大索引
    def find_last_index(self, num_list, num) -> int:
        tmp = num_list[:]
        tmp.reverse()
        index = tmp.index(num)
        return len(num_list)-1 - index

if __name__ == "__main__":
    print(Solution().maximumSwap(11921))

