#
# @lc app=leetcode.cn id=448 lang=python3
#
# [448] 找到所有数组中消失的数字
#
# https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/description/
#
# algorithms
# Easy (47.65%)
# Total Accepted:    6.7K
# Total Submissions: 14K
# Testcase Example:  '[4,3,2,7,8,2,3,1]'
#
# 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
#
# 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
#
# 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
#
# 示例:
#
#
# 输入:
# [4,3,2,7,8,2,3,1]
#
# 输出:
# [5,6]
#
#
#
from typing import List


class Solution:
    # 不断交换,把数字归到其索引所在处
    # 由于数字在1-n之间,因此一定能找到原位
    # 交换时有以下情况:
    # 1.数字的原位上存在错位的数字,则直接交换,继续寻找该错位数字的原位
    # 2.原位上存在相同的数字,即本数是重复多次的数字,则本位置空出(置0)向前寻找下一个数
    # 3.原位上不存在数(为0),直接填入,并将本位置空出
    # 交换完毕后,最后遍历数组上的空位即可

    # 思路2: 使用正负号来区别数字是否出现过
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        length = len(nums)
        if length == 0 or length == 1:
            return []

        i = 0
        while i < length:
            cur_num = nums[i]

            # 位置正确, 检查下一个位置
            if cur_num == i + 1:
                i += 1
                continue

            # 检查num的目标位置
            j = cur_num - 1
            target_num = nums[j]

            # 目的位置为空或本数重复,直接挪移(覆盖),并把当前位置留空,前进一步
            if target_num == 0 or target_num == cur_num:
                nums[j] = cur_num
                nums[i] = 0
                i += 1
            # 目的位置被其他数占用,则交换,继续下一轮判断
            else:
                nums[i], nums[j] = nums[j], nums[i]

        # 扫描0
        results = []
        for i in range(length):
            if nums[i] == 0:
                results.append(i + 1)

        return results


if __name__ == "__main__":
    print(Solution().findDisappearedNumbers([1, 1, 1, 1, 5]))

