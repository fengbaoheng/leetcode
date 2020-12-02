#
# @lc app=leetcode.cn id=114 lang=python3
#
# [114] 二叉树展开为链表
#
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def flatten(self, root: TreeNode) -> None:
        try:
            if root is None:
                return

            # 分别序列化左右子树
            self.flatten(root.left)
            self.flatten(root.right)

            # 拼接链表, 左子树插入在root与右子树之间
            if root.left is not None:
                node = root.left
                # 找到左子树的尾节点
                while node.right is not None:
                    node = node.right
                
                # 拼接
                node.right = root.right
                root.right = root.left
                root.left = None

        except Exception as e:
            raise e
        

