#
# @lc app=leetcode.cn id=113 lang=python3
#
# [113] 路径总和 II
#
from typing import List

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # 不断迭代，将sum数值拆分直至根节点结束
    # 节点数值可能为负数
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        try:
            if root is None:
                return []
            
            # 叶子节点
            if root.left is None and root.right is None:
                if root.val == sum:
                    return [[root.val]]
                else:
                    return []
                
            # 存在子树，向下递归拆分
            sub_sum = sum - root.val
            sub_results = self.pathSum(root.left, sub_sum)
            sub_results.extend(self.pathSum(root.right, sub_sum))
            
            # 当前节点值拼接子树结果
            results = [[root.val] + result for result in sub_results]
            
            return results
        except Exception as e:
            raise e
