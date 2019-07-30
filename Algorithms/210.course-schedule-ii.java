/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */
import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> ready = new LinkedList<>();
        Queue<Integer> finished = new LinkedList<>();

        // 建立初始约束关系
        int[] pre = new int[numCourses];
        Arrays.fill(pre, 0);
        Map<Integer, Set<Integer>> after = new HashMap<>();
        for (int[] req : prerequisites) {
            int course = req[0];
            int preCourse = req[1];
            if (!after.containsKey(preCourse)) {
                after.put(preCourse, new HashSet<>());
            }
            after.get(preCourse).add(course);
            pre[course] += 1;
        }

        for (int i = 0; i < numCourses; i++) {
            if (pre[i] == 0) {
                ready.add(i);
            }
        }


        while (ready.size() > 0) {
            // 从ready中取出课程加入finished
            int course = ready.poll();
            finished.offer(course);
            pre[course] = -1;

            // 更新该课程的后续课程是否可学
            if (after.containsKey(course)) {
                for (int checkCourse : after.get(course)) {
                    if (pre[checkCourse] == -1) {
                        continue;
                    }

                    if (pre[checkCourse] == 1) {
                        ready.offer(checkCourse);
                        pre[checkCourse] = -1;
                    } else {
                        pre[checkCourse] -= 1;
                    }
                }
            }
        }

        // 检查是否都学完了
        if (finished.size() == numCourses) {
            return finished.stream().mapToInt(Integer::valueOf).toArray();
        } else {
            return new int[0];
        }
    }
}

