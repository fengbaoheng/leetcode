#
# @lc app=leetcode.cn id=207 lang=python3
#
# [207] 课程表
#
from typing import List


class Solution:
    # 不断遍历课程列表
    # 如果能够解开限制，则解开
    # 若遍历完都无法更改限制，则发生死锁，返回false
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        finished_course = set(range(numCourses))
        unfished_course = set([])

        # 初始化先修课程约束
        pre_courses = {}
        for pre in prerequisites:
            course, pre = pre

            unfished_course.add(course)

            if course in pre_courses:
                pre_courses[course].add(pre)
            else:
                pre_courses[course] = set([pre])

        finished_course = finished_course - unfished_course

        # 不断对未完成课程循环
        while len(finished_course) != numCourses:
            is_dead = True

            # 尽可能根据已学的课程解除先修课限制
            # 如果一个都解不开则死锁退出
            for course in list(unfished_course):
                pres = pre_courses[course]
                remain_pres = pres & unfished_course

                # 所有先修课都完成了
                if len(remain_pres) == 0:
                    is_dead = False
                    finished_course.add(course)
                    unfished_course.remove(course)
                    pre_courses.pop(course)
                elif len(remain_pres) < len(pres):
                    is_dead = False
                    pre_courses[course] = remain_pres

            if is_dead:
                return False

        return True


if __name__ == "__main__":
    print(Solution().canFinish(3, [[2, 0], [2, 1]]))
