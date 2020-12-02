/*
 * @lc app=leetcode.cn id=636 lang=java
 *
 * [636] 函数的独占时间
 */

// @lc code=start
import java.util.*;


class Solution {
    int[] time;
    Deque<Fun> stack;

    public int[] exclusiveTime(int n, List<String> logs) {
        this.time = new int[n];
        this.stack = new ArrayDeque<>(n);

        for (String log : logs) {
            String[] split = log.split(":");
            int id = Integer.parseInt(split[0]);
            boolean isStart = "start".equals(split[1]);
            int time = Integer.parseInt(split[2]);
            handle(id, isStart, time);
        }

        return time;
    }

    private void handle(int id, boolean isStart, int time) {
        if (isStart) {
            if (!stack.isEmpty()) {
                stack.peek().pause(time - 1);
            }
            stack.push(new Fun(id, time));
        } else {
            Fun f = stack.pop();
            f.pause(time);
            if (!stack.isEmpty()) {
                stack.peek().start(time + 1);
            }
        }
    }

    private class Fun {
        final int id;
        int startTime;

        public Fun(int id, int curTime) {
            this.id = id;
            start(curTime);
        }

        private void start(int curTime) {
            startTime = curTime;
        }

        private void pause(int curTime) {
            time[id] += 1 + curTime - startTime;
        }
    }
}
// @lc code=end

