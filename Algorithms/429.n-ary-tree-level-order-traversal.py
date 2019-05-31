#
# @lc app=leetcode.cn id=429 lang=python3
#
# [429] N叉树的层序遍历
#
from typing import List


class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children


class Solution:
    def levelOrder(self, root: "Node") -> List[List[int]]:
        try:
            if root is None:
                return []
            
            result = []

            cur_layer = []
            next_layer = [root]
            
            while len(next_layer) != 0:
                cur_layer = next_layer
                next_layer = []
                layer_value = []

                for node in cur_layer:
                    if node is None:
                        continue
                    else:
                        layer_value.append(node.val)
                        if node.children is not None:
                            next_layer.extend(node.children)
                
                result.append(layer_value)

            return result

        except Exception as e:
            raise e
        

