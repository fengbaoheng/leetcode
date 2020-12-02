#
# @lc app=leetcode.cn id=513 lang=python3
#
# [513] 找树左下角的值
#
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # 层遍历找最后一层第一个
    def findBottomLeftValue(self, root: TreeNode) -> int:
        if root is None:
            return -1
        
        cur_layer = []
        next_layer = [root]

        while len(next_layer) != 0:
            cur_layer = next_layer
            next_layer = []

            for node in cur_layer:
                if node.left:
                    next_layer.append(node.left)
                if node.right:
                    next_layer.append(node.right)
        
        return cur_layer[0].val

