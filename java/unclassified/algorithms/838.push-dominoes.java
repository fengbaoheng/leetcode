/*
 * @lc app=leetcode.cn id=838 lang=java
 *
 * [838] 推多米诺
 */

// @lc code=start
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String pushDominoes(String dominoes) {
        int len = dominoes.length();
        char[] state = new char[len];
        int[] power = new int[len];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            char c = dominoes.charAt(i);
            state[i] = '.';
            if (c != '.') {
                queue.add(i);
                power[i] = c == 'L' ? -1 : 1;
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] nextPower = new int[len];

            for (int i = 0; i < size; i++) {
                int index = queue.poll();

                int curPower = power[index];
                int curState = state[index];

                if (curPower == 0 || curState != '.') {
                    continue;
                }

                if (curPower == -1) {
                    state[index] = 'L';
                    if (index > 0) {
                        nextPower[index - 1]--;
                        queue.add(index - 1);
                    }
                } else if (curPower == 1) {
                    state[index] = 'R';
                    if (index < len - 1) {
                        nextPower[index + 1]++;
                        queue.add(index + 1);
                    }
                }
            }

            power = nextPower;
        }


        return new String(state);
    }
}
// @lc code=end

