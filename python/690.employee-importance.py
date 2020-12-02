#
# @lc app=leetcode.cn id=690 lang=python3
#
# [690] 员工的重要性
#
import unittest


class Employee:
    def __init__(self, id, importance, subordinates):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates


class Solution:
    def getImportance(self, employees, id):
        # 字典记录所有员工
        d = {}
        for e in employees:
            d[e.id] = e
        
        # 使用栈存储所有下属
        # 使用集合存储关联的员工
        e_id_stack = [id]
        e_id_set = set([])

        while e_id_stack:
            e_id = e_id_stack.pop()
            e_id_set.add(e_id)

            e_id_stack.extend(d[e_id].subordinates)
        
        
        importance = 0
        for e_id in e_id_set:
            importance  += d[e_id].importance
        
        return importance



class TestSolution(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()
        self.employee_list = []
        self.id = 0
        self.result = 0

    def tearDown(self):
        employees = []
        for i, im, sub in self.employee_list:
            employees.append(Employee(i, im, sub))

        self.assertEqual(self.result, self.solution.getImportance(employees, self.id))

    def test_default(self):
        self.employee_list = [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]]
        self.id = 1
        self.result = 11

if __name__ == "__main__":
    unittest.main()
