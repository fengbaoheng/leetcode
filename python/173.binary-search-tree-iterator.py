#
# @lc app=leetcode.cn id=173 lang=python3
#
# [173] 二叉搜索树迭代器
#
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class BSTIterator:
    def __init__(self, root: TreeNode):
        self.stack = []

        if root is not None:
            self.stack.append(root)

    # 并不需要一次全部遍历完
    # 每次只找到最小的即可
    def next(self) -> int:
        node = self.stack.pop()

        # 没有左子树的节点，即为当前最小的节点
        while node.left is not None:
            left_node = node.left

            node.left = None
            self.stack.append(node)

            node = left_node

        # 缓存该节点的右子树
        if node.right is not None:
            self.stack.append(node.right)

        return node.val

    def hasNext(self) -> bool:
        return len(self.stack) != 0
