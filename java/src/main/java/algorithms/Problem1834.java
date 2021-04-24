package algorithms;

import java.util.*;

/**
 * 1834.单线程 CPU
 */
public class Problem1834 {

    static class Solution {
        public int[] getOrder(int[][] tasks) {
            int n = tasks.length;

            // 任务列表按照进入队列时间排序
            List<Task> taskList = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int[] info = tasks[i];
                taskList.add(new Task(i, info[0], info[1]));
            }
            taskList.sort(Comparator.comparingInt(task -> task.enterTime));


            // 任务队列，高优先级任务在前
            PriorityQueue<Task> taskQueue = new PriorityQueue<>(n);
            List<Integer> results = new ArrayList<>(n);

            int time = 1;
            while (taskList.size() > 0 || taskQueue.size() > 0) {
                // 添加任务
                while (taskList.size() > 0) {
                    Task task = taskList.get(0);
                    // 任务还未到达入队时间
                    if (task.enterTime > time) {
                        break;
                    }
                    taskList.remove(0);
                    taskQueue.add(task);
                }


                // 执行任务
                if (taskQueue.isEmpty()) {
                    // 队列为空，则直接将时间跳转到最近的下一条任务
                    time = taskList.get(0).enterTime;
                } else {
                    // 取出任务执行
                    Task task = taskQueue.poll();
                    results.add(task.index);
                    time += task.duration;
                }
            }

            return results.stream().mapToInt(Integer::intValue).toArray();
        }

        /**
         * 任务对象
         */
        private static class Task implements Comparable<Task> {
            int index;
            int enterTime;
            int duration;

            public Task(int index, int enterTime, int duration) {
                this.index = index;
                this.enterTime = enterTime;
                this.duration = duration;
            }

            /**
             * 执行时间最短 + 下标最小 进行任务执行的优先级比较
             */
            @Override
            public int compareTo(Task o) {
                if (this.duration == o.duration) {
                    return this.index - o.index;
                } else {
                    return this.duration - o.duration;
                }
            }
        }
    }
}