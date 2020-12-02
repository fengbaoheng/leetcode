#
# @lc app=leetcode.cn id=102 lang=python3
#
# [102] 二叉树的层次遍历
#
from typing import List
from queue import Queue


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 使用队列，记录节点及层次
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        try:
            if root is None:
                return []

            result = []
            queue = Queue()
            queue.put((root, 0))

            while not queue.empty():
                node, layer = queue.get()

                # 添加结果
                if layer >= len(result):
                    result.append([node.val])
                else:
                    result[layer].append(node.val)

                # 补充队列
                if node.left is not None:
                    queue.put((node.left, layer+1))
                if node.right is not None:
                    queue.put((node.right, layer+1))

            return result

        except:
            return []
