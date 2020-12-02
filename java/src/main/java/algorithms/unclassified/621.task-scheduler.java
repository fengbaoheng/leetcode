/*
 * @lc app=leetcode.cn id=621 lang=java
 *
 * [621] 任务调度器
 */

// @lc code=start
import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 初始时所有任务都是准备好的
        Queue<Task> readyTasks = new PriorityQueue<>(getTask(tasks));
        Queue<Task> sleepTasks = new ArrayDeque<>();

        int time = 0;
        while (!readyTasks.isEmpty() || !sleepTasks.isEmpty()) {
            time = nextTime(time, readyTasks, sleepTasks);

            // 唤醒可以执行的任务
            while (!sleepTasks.isEmpty() && sleepTasks.peek().canExecute(time)) {
                readyTasks.offer(sleepTasks.poll());
            }


            // 取出一个任务执行
            if (!readyTasks.isEmpty()) {
                Task task = readyTasks.poll();
                task.execute(time, n);

                // 若任务还未执行完，则放入休眠队列中
                if (!task.isFinished()) {
                    sleepTasks.offer(task);
                }
            }
        }


        return time;
    }

    private int nextTime(int curTime, Queue<Task> readyTasks, Queue<Task> sleepTasks) {
        if (!readyTasks.isEmpty()) {
            return curTime + 1;
        }

        return sleepTasks.peek().getReadyTime();
    }

    private List<Task> getTask(char[] tasks) {
        Map<Character, Integer> map = new HashMap<>(26);
        for (char ch : tasks) {
            map.merge(ch, 1, Integer::sum);
        }

        LinkedList<Task> result = new LinkedList<>();
        map.forEach((ch, count) -> {
            result.add(new Task(count));
        });

        return result;
    }
}

class Task implements Comparable<Task> {
    private int readyTime = 1;
    private int remainCount;

    public int getReadyTime() {
        return readyTime;
    }

    public Task(int remainCount) {
        this.remainCount = remainCount;
    }

    public boolean canExecute(int curTime) {
        return remainCount > 0 && curTime >= readyTime;
    }

    public boolean isFinished() {
        return remainCount <= 0;
    }

    public void execute(int curTime, int sleepTime) {
        remainCount--;
        readyTime = curTime + sleepTime + 1;
    }

    @Override
    public int compareTo(Task o) {
        return o.remainCount - this.remainCount;
    }
}
// @lc code=end

