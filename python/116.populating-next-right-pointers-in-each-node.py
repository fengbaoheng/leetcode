#
# @lc app=leetcode.cn id=116 lang=python3
#
# [116] 填充每个节点的下一个右侧节点指针
#
class Node:
    def __init__(self, val, left, right, next):
        self.val = val
        self.left = left
        self.right = right
        self.next = next

class Solution:
    # 左右两棵子树递归连接自身内部的指针
    # 最后连接两棵子树间的指针
    def connect(self, root: 'Node') -> 'Node':
        try:
            if root is None:
                return None
            
            if root.left is None and root.right is None:
                return root

            # 左右子树内部完成连接
            self.connect(root.left)
            self.connect(root.right)

            # 递归连接左右子树的每一层
            # 左子树的最右侧与右子树的最左侧
            left_last = root.left
            right_first = root.right
            while left_last is not None:
                left_last.next = right_first

                left_last = left_last.right
                right_first = right_first.left
            
            return root

        except Exception as e:
            raise e
        

