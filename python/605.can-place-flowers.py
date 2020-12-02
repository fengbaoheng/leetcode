#
# @lc app=leetcode.cn id=605 lang=python3
#
# [605] 种花问题
#
# https://leetcode-cn.com/problems/can-place-flowers/description/
#
# algorithms
# Easy (26.43%)
# Total Accepted:    4.5K
# Total Submissions: 16.4K
# Testcase Example:  '[1,0,0,0,1]\n1'
#
# 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
#
# 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n
# 朵花？能则返回True，不能则返回False。
#
# 示例 1:
#
#
# 输入: flowerbed = [1,0,0,0,1], n = 1
# 输出: True
#
#
# 示例 2:
#
#
# 输入: flowerbed = [1,0,0,0,1], n = 2
# 输出: False
#
#
# 注意:
#
#
# 数组内已种好的花不会违反种植规则。
# 输入的数组长度范围为 [1, 20000]。
# n 是非负整数，且不会超过输入数组的大小。
#
#
#


class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        length = len(flowerbed)

        if n == 0:
            return True
        if length == 0:
            return False

        # 数组首尾较为特殊，因此补充两个0
        flowerbed = [0] + flowerbed + [0]

        count = 0
        i = 1
        while i <= length:
            # 如果当前为1，则i+1一定为0，因此下一个只需判断i+2
            if flowerbed[i] == 1:
                i += 2
            elif flowerbed[i] == 0:
                if flowerbed[i+1] == 1:
                    i += 3
                else:
                    flowerbed[i] = 1
                    count += 1
                    if count >= n:
                        return True

        return False
