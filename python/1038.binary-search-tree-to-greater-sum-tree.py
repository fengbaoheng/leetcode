#
# @lc app=leetcode.cn id=1038 lang=python3
#
# [1038] 从二叉搜索树到更大和树
#

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # 递归操作
    # 顺序: 右子树->根节点->左子树
    # 递归时要传递参数,其值是比当前树中最大节点还要大的累加和
    def bstToGst(self, root: TreeNode) -> TreeNode:
        try:
            if root is None:
                return None

            self.to_gst(root, 0)
            
            return root
            
        except Exception as e:
            raise e

    # 返回累加和
    def to_gst(self, root:TreeNode, sum:int)->int:
        try:
            if root is None:
                return sum
            
            # 先处理右子树
            sum = self.to_gst(root.right, sum)
            
            # 根节点
            root.val += sum
            sum = root.val

            # 左子树
            sum = self.to_gst(root.left, sum)

            return sum
            

        except Exception as e:
            raise e

        

