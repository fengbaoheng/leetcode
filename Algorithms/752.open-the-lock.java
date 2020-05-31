/*
 * @lc app=leetcode.cn id=752 lang=java
 *
 * [752] 打开转盘锁
 */

// @lc code=start
import java.util.*;

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<Integer> deadSet = new HashSet<>(deadends.length);
        for (String deadend : deadends) {
            deadSet.add(Integer.parseInt(deadend));
        }
        return bfs(deadSet, Integer.parseInt(target));
    }

    private int bfs(Set<Integer> visited, int target) {
        if (visited.contains(0)) {
            return -1;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        visited.add(0);

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                if (num == target) {
                    return steps;
                }

                for (int next : next(num)) {
                    if (!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    private List<Integer> next(int num) {
        int[] arr = getNumArr(num);
        List<Integer> nextNum = new ArrayList<>(8);
        for (int i = 0; i < 4; i++) {
            int old = arr[i];
            arr[i] = bit(old + 1);
            nextNum.add(getArrNum(arr));
            arr[i] = bit(old - 1);
            nextNum.add(getArrNum(arr));
            arr[i] = old;
        }
        return nextNum;
    }

    private int[] getNumArr(int num) {
        int[] arr = {0, 0, 0, 0};
        for (int i = 3; i >= 0; i--) {
            if (num == 0) {
                break;
            }
            arr[i] = num % 10;
            num /= 10;
        }
        return arr;
    }

    private int getArrNum(int[] arr) {
        int num = 0;
        for (int i = 0; i < 4; i++) {
            num = num * 10 + arr[i];
        }
        return num;
    }

    private int bit(int i) {
        switch (i) {
            case -1:
                return 9;
            case 10:
                return 0;
            default:
                return i;
        }
    }
}
// @lc code=end

