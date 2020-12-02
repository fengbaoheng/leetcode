#
# @lc app=leetcode.cn id=946 lang=python3
#
# [946] 验证栈序列
#

from typing import List


class Solution:
    # 模拟思路即可
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        try:
            if len(pushed) == 0 or len(pushed) == 1:
                return True

            # 模拟的栈
            stack = []

            for num in popped:
                if len(stack) > 0 and num == stack[-1]:
                    # 恰好要弹出的元素在栈顶
                    stack.pop()
                elif num in pushed:
                    # 要弹出的元素,还没入栈, 把该元素之前的所有元素入栈
                    index = pushed.index(num)
                    stack.extend(pushed[:index])
                    pushed = pushed[index+1:]
                else:
                    return False
            return True
        except Exception as e:
            raise e
    
